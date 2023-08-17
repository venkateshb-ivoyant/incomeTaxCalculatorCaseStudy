package com.ivoyant.IncomeTaxCalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class UserDeductions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userDeductionId;

    private String pan;
    private double standardDeduction;
    private double HRA;
    private double homeLoan;
    private double fixedDeposit;
    private double insurranceAmt;
    private double otherDeductions;

}
