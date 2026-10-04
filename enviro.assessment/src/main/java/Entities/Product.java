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

public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private Long investorId;
    private String type;
    private double balance;
    private String name;
}