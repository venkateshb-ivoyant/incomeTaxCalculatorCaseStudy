package com.ivoyant.IncomeTaxCalculator.repository;

import com.ivoyant.IncomeTaxCalculator.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByPan(String pan);
   // Optional<Users> findBYUserID(Long userID);

}
