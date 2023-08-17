package com.ivoyant.IncomeTaxCalculator.controller;

import com.ivoyant.IncomeTaxCalculator.entity.UserDeductions;
import com.ivoyant.IncomeTaxCalculator.entity.UserIncome;
import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserDeductionsRepository;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/updateDeductions/")
public class UserDeductionController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDeductionsRepository userDeductionsRepository;


    @PostMapping("createDeduction/{pan}/{secretKey}")
    public UserDeductions createDeduction(@PathVariable String pan, @PathVariable int secretKey, @RequestBody UserDeductions userDeductions) {
        Users user = userRepository.findByPan(pan);
        if (user.getSecretKey() == secretKey) {
            userDeductions.setPan(user.getPan());
            return userDeductionsRepository.save(userDeductions);
        }
        return userDeductions;
    }
}
