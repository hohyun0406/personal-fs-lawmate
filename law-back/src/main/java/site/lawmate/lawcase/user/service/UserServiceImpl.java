package site.lawmate.lawcase.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.lawmate.lawcase.common.component.Messenger;
import site.lawmate.lawcase.common.component.security.JwtProvider;
import site.lawmate.lawcase.user.model.User;
import site.lawmate.lawcase.user.model.UserDto;
import site.lawmate.lawcase.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final JwtProvider jwtProvider;

    @Override
    public Messenger save(UserDto userDto) {
        User savedUser = repository.save(dtoToEntity(userDto));
        return Messenger.builder().message(repository.findById(savedUser.getId()).isPresent() ? "SUCCESS" : "FAILURE").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Messenger modify(UserDto dto) {
        return null;
    }

    @Override
    @Transactional
    public Messenger login(UserDto userDto) {
        User user = repository.findByUsername(userDto.getUsername()).get();
        String accessToken = jwtProvider.createToken(entityToDto(user));
        boolean flag = user.getPassword().equals(userDto.getPassword());

//        boolean flag = repository.findByUsername(userDto.getUsername()).get().getPassword().equals(userDto.getPassword());
//        String token = jwtProvider.createToken(userDto);

        //토큰을 각 세션(Header, Payload, Signature로 분할)
        jwtProvider.printPayload(accessToken);

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? accessToken : "None")
                .build();
    }


    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
