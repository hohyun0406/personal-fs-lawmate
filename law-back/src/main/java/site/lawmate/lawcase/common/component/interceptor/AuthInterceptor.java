package site.lawmate.lawcase.common.component.interceptor;

import site.lawmate.lawcase.common.component.security.JwtProvider;
import site.lawmate.lawcase.user.model.User;
import site.lawmate.lawcase.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final UserRepository repository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        return Stream.of(request)
                .map(i->jwtProvider.extractTokenFromHeader(i))
                .filter(token -> !token.equals("undefined"))
                .peek(token->log.info("1 - 인터셉터 토큰 로그 Bearer 포함 : {}",token))
                .map(i->jwtProvider.getPayload(i).get("userId", Long.class))
                .peek(i->log.info("1.5 : {}", i))
                .map(userId->repository.findById(userId))
                .filter(user -> user.isPresent())
                .peek(user->log.info("2- 인터셉터 사용자 id : {}", user))
                .findFirst()
                .isPresent();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
