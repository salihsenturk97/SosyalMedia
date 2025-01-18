package com.salihsenturk.service;

import com.salihsenturk.dto.request.CreateUserRequestDto;
import com.salihsenturk.dto.request.RegisterRequestDto;
import com.salihsenturk.dto.response.LoginResponseDto;
import com.salihsenturk.entity.Auth;
import com.salihsenturk.manager.UserProfileManager;
import com.salihsenturk.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = authRepository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());

        userProfileManager.createUser(CreateUserRequestDto.builder()
                .username(auth.getUserName())
                .authId(auth.getId())
                .email(auth.getEmail())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return authRepository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
