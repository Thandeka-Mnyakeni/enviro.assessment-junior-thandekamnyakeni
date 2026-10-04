package com.enviro.assessment.junior.thandekamnyakeni.entities;


import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data

public class WithdrawNotice {
    @Id
    @GeneratedValue
    private Long id;
    private Long investorId;
    private String productType;
    private double amount;
    private LocalDate date = LocalDate.now();
    private String status;
}