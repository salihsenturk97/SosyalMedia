package com.salihsenturk.service;

import com.salihsenturk.document.UserProfile;
import com.salihsenturk.dto.request.CreateUserRequestDto;
import com.salihsenturk.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    public void createUser(CreateUserRequestDto dto) {
        repository.save(UserProfile.builder()
                .authId(dto.getAuthId())
                .userName(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return  repository.findAll();
    }
}
