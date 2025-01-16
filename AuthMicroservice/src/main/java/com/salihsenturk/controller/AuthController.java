package com.salihsenturk.controller;

import com.salihsenturk.dto.request.RegisterRequestDto;
import com.salihsenturk.dto.response.LoginResponseDto;
import com.salihsenturk.entity.Auth;
import com.salihsenturk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.salihsenturk.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;
    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto) {
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw  new RuntimeException("Şifreler uyuşmuyor");
        return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }
}
