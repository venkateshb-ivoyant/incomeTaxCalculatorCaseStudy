package com.ivoyant.IncomeTaxCalculator.controller;

import com.ivoyant.IncomeTaxCalculator.entity.UserDeductions;
import com.ivoyant.IncomeTaxCalculator.entity.UserIncome;
import com.ivoyant.IncomeTaxCalculator.entity.Users;
import com.ivoyant.IncomeTaxCalculator.repository.UserDeductionsRepository;
import com.ivoyant.IncomeTaxCalculator.repository.UserIncomeRepository;
import com.ivoyant.IncomeTaxCalculator.repository.UserRepository;
import com.ivoyant.IncomeTaxCalculator.service.CalculateTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/getTaxPayableAmount/" )
public class CalculateTaxPayable {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserIncomeRepository userIncomeRepository;
    @Autowired
    private UserDeductionsRepository userDeductionsRepository;
    @Autowired
    private CalculateTaxService calculateTaxService;

    @GetMapping("{pan}/{secretKey}/calculateTaxPayable")
    public ResponseEntity<String> calculateSummary(
            @PathVariable String pan,
            @PathVariable int secretKey) {

        Users user = userRepository.findByPan(pan);
        int userSecretKey = user.getSecretKey();
        if (user == null || userSecretKey != secretKey) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserIncome userIncomes = userIncomeRepository.findByPan(pan);
        UserDeductions userDeductions = userDeductionsRepository.findByPan(pan);

        double totalIncome = userIncomes.getOtherIncome()+userIncomes.getSalary();
        double totalDeductions = userDeductions.getStandardDeduction()+userDeductions.getOtherDeductions()+userDeductions.getFixedDeposit()+userDeductions.getHomeLoan()+userDeductions.getHRA()+userDeductions.getInsurranceAmt();

        double totalAmountToBeTaxCalCulated =totalIncome-totalDeductions;
        double totaltaxToBePayable= calculateTaxService.calculateIncomeTax(totalAmountToBeTaxCalCulated);
        String respone= "Tax Calculated on Amount"+totalAmountToBeTaxCalCulated+"And Tax to be payable is "+totaltaxToBePayable;
        return ResponseEntity.ok(respone);
    }

}
