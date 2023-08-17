package com.ivoyant.IncomeTaxCalculator.service;

import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;
   private Logger logger =  LoggerFactory.getLogger(UsersService.class);

    public Users save(Users users){
        String pan = users.getPan();
        int secretKey= users.getSecretKey();
        if(pan != null && !pan.isEmpty() && pan.length() == 10 && secretKey != 0){
            return userRepository.save(users);
        }else {
            logger.error("USER PAN is EMPTY or Secret Key is 0");
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
