package com.ivoyant.IncomeTaxCalculator.service;

import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public Users save(Users users){
        String pan = users.getPan();
        int secretKey= users.getSecretKey();
        if(pan != null && !pan.isEmpty() && pan.length() == 10 && secretKey != 0){
            return userRepository.save(users);
        }else {
            System.out.println("USER PAN is Empty or secret key is 0");
        }
        return null;
    }

    public List<Users> getAllUsers() {
        return  userRepository.findAll();
    }
    public Optional<Users>getUserByID(Long userId){
        return  userRepository.findById(userId);
    }

}
