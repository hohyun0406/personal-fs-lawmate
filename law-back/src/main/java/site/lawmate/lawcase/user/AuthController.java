package site.lawmate.lawcase.user;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.lawmate.lawcase.common.component.Messenger;
import site.lawmate.lawcase.user.model.UserDto;
import site.lawmate.lawcase.user.service.UserServiceImpl;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
@Slf4j
public class AuthController {
    private final UserServiceImpl service;

    //cqrs command : create, update, delete
    @PostMapping("/join")
    public ResponseEntity<Messenger> join(@RequestBody UserDto userDto){
        log.info("save request info : {} ", userDto);
        return ResponseEntity.ok(service.save(userDto));
    }

    //query : read
    @PostMapping("/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto userDto) {
        log.info("login request : {}", userDto);
        Messenger messenger = service.login(userDto);
        return ResponseEntity.ok(messenger);
    }

}
