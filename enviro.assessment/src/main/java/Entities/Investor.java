package com.enviro.assessment.junior.thandekamnyakeni.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data

public class Investor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String email;
}


    

