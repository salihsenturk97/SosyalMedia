package com.salihsenturk.service;

import com.salihsenturk.dto.request.RegisterRequestDto;
import com.salihsenturk.dto.response.LoginResponseDto;
import com.salihsenturk.entity.Auth;
import com.salihsenturk.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth register(RegisterRequestDto dto) {
        return authRepository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
    }

    public Boolean login(LoginResponseDto dto) {
        return authRepository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
