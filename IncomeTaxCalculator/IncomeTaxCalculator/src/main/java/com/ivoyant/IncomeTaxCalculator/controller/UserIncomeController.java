package com.ivoyant.IncomeTaxCalculator.controller;

import com.ivoyant.IncomeTaxCalculator.entity.UserIncome;
import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserIncomeRepository;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/updateIncome/")
public class UserIncomeController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserIncomeRepository userIncomeRepository;

    @PostMapping("createIncome/{pan}/{secretKey}")
    public UserIncome createIncome(@PathVariable String pan, @PathVariable int secretKey, @RequestBody UserIncome userIncome) {
        Users user = userRepository.findByPan(pan);
        if (user.getSecretKey() == secretKey) {
            userIncome.setPan(user.getPan());
            return userIncomeRepository.save(userIncome);
        }
        return userIncome;
    }
}
