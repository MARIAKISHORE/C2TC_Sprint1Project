package com.devmart.accesshubservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessHubRepository extends JpaRepository<AppUserEntity, Integer> {

    Optional<AppUserEntity> findByEmail(String email);
}
