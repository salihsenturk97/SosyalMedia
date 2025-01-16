package com.salihsenturk.repository;

import com.salihsenturk.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {

    Boolean existsByUserNameAndPassword(String password, String password1);
}
