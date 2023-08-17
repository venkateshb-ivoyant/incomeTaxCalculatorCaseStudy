package com.ivoyant.IncomeTaxCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ivoyant.IncomeTaxCalculator.repository")
public class IncomeTaxCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncomeTaxCalculatorApplication.class, args);
    }

}
