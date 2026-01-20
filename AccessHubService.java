package com.devmart.accesshubservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccessHubService {

    @Autowired
    private AccessHubRepository vault;

    public List<AppUserEntity> getAllUsers() {
        return vault.findAll();
    }

    public AppUserEntity getUserById(Integer id) {
        return vault.findById(id).orElseThrow();
    }

    public void registerUser(AppUserEntity user) {
        vault.save(user);
    }

    public void deleteUser(Integer id) {
        vault.deleteById(id);
    }

    public AppUserEntity getUserByEmail(String email) {
        return vault.findByEmail(email).orElse(null);
    }
}
