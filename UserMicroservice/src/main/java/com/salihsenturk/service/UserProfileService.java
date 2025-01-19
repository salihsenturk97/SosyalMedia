package com.salihsenturk.service;

import com.salihsenturk.document.UserProfile;
import com.salihsenturk.dto.request.CreateUserRequestDto;
import com.salihsenturk.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final CacheManager cacheManager;
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

    @Cacheable("upper-case")
    public String upperName(String name) {

        String result = name.toUpperCase();
        try{
            Thread.sleep(3000L);
        }catch (Exception e){}
        return result;
    }

    public void clearCache(String cacheName){
        cacheManager.getCache(cacheName).clear();
    }
}
