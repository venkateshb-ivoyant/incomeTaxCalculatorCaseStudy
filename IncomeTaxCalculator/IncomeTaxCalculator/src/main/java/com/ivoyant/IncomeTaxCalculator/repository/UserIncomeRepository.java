package com.ivoyant.IncomeTaxCalculator.repository;

import com.ivoyant.IncomeTaxCalculator.entity.UserIncome;
import com.ivoyant.IncomeTaxCalculator.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIncomeRepository extends JpaRepository<UserIncome, Long> {
    UserIncome findByPan(String pan);
}
