//package com.rod.api.common.security;
//
//
//import com.rod.api.common.component.Messenger;
//import com.rod.api.common.security.service.AuthServiceImpl;
//import com.rod.api.user.model.UserDto;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@ApiResponses(value = {
//        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//        @ApiResponse(responseCode = "404", description = "Customer not found")})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(path = "/api/auth")
//@Slf4j
//public class AuthControllerLegacy {
//    private final AuthServiceImpl service;
//    @PostMapping("/login")
//    public ResponseEntity<Messenger> login(@RequestBody UserDto userDto) {
//        log.info("login request : {}", userDto);
//        return ResponseEntity.ok(service.login(userDto));
//    }
//}
