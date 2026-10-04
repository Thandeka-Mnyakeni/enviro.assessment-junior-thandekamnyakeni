package com.enviro.assessment.junior.thandekamnyakeni.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Repository

public interface InvestorRepository extends JpaRepository <Investor , Long>{}

public interface ProductRepository extends JpaRepository <Product , Long>{
    List<Product> findByInvestorId(Long investorId);
}

public interface WithdrawRepository extends JpaRepository <WithdrawNotice , Long>{
    List<WithdrawNotice> findByInvestorId(Long investorId);
}