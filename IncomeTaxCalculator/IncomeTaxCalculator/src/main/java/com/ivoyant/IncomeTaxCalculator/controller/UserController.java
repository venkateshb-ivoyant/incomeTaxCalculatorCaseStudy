package com.ivoyant.IncomeTaxCalculator.controller;

import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import com.ivoyant.IncomeTaxCalculator.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users/")
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("createUser")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        return ResponseEntity.ok(usersService.save(user));
    }
    @GetMapping("getAllUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return  ResponseEntity.ok(usersService.getAllUsers());
    }
    @GetMapping("getUserById/{userId}")
    public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long userId){
        return  ResponseEntity.ok(usersService.getUserByID(userId));
    }

}
