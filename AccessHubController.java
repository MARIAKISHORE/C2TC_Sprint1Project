package com.devmart.accesshubservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class AccessHubController {

    @Autowired
    private AccessHubService logic;

    // GET all users
    @GetMapping
    public List<AppUserEntity> listAll() {
        return logic.getAllUsers();
    }

    // GET user by ID
    @GetMapping("/{id}")
    public ResponseEntity<AppUserEntity> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(logic.getUserById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // CREATE user
    @PostMapping
    public ResponseEntity<?> add(@RequestBody AppUserEntity user) {
        logic.registerUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            logic.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
