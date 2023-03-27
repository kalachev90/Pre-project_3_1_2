package com.example.preproject_3_1_2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;
    private String department;
    @Min(1)
    private int salary;
}
