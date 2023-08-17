package com.ivoyant.IncomeTaxCalculator.controller;

import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import com.ivoyant.IncomeTaxCalculator.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users/")
public class UserController extends RuntimeException {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("createUser")
    public Object createUser(@RequestBody Users user) {
        try {
            return ResponseEntity.ok(usersService.save(user));
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest();
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("getUserById/{userId}")
    public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(usersService.getUserByID(userId));
    }

}
