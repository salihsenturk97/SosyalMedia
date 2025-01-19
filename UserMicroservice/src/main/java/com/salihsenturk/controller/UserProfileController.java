package com.salihsenturk.controller;

import com.salihsenturk.document.UserProfile;
import com.salihsenturk.dto.request.CreateUserRequestDto;
import com.salihsenturk.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salihsenturk.config.RestApis.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;


    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto) {
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }



    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name){
        return ResponseEntity.ok(userProfileService.upperName(name));
    }

    @PostMapping("/clear-cache")
    public ResponseEntity<?> clearCache(@RequestParam String cacheName) {
        userProfileService.clearCache(cacheName);
        return ResponseEntity.ok("Cache cleared for: " + cacheName);
    }
}
