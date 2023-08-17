package com.ivoyant.IncomeTaxCalculator.repository;

import com.ivoyant.IncomeTaxCalculator.entity.UserDeductions;
import com.ivoyant.IncomeTaxCalculator.entity.UserIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeductionsRepository extends JpaRepository<UserDeductions, Long> {
    UserDeductions findByPan(String pan);
}
