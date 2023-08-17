package com.ivoyant.IncomeTaxCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateTaxService {

    public double calculateIncomeTax(double taxableIncome) {
        if (taxableIncome <= 500000) {
            return taxableIncome * 0.10;
        } else if (taxableIncome > 500000 && taxableIncome <= 1000000) {
            return 500000 * 0.10 + (taxableIncome - 500000) * 0.20;
        } else {
            return 500000 * 0.10 + 500000 * 0.20 + (taxableIncome - 1000000) * 0.25;
        }
    }
}


