package com.teamx.petadopt.repository;

import com.teamx.petadopt.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
