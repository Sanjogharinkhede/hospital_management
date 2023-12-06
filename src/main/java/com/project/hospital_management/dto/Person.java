package com.project.hospital_management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotBlank(message = "Name can't be blank")
    @NotNull(message = "Name can't be null")
    private String name;
    
    
    @Column(unique = true)
    @Min(value = 6000000000l)
    @Max(value = 9999999999l)
    private long phone;
    
    
    @NotBlank(message = "Email can't be blank")
    @NotNull(message = "Email can't be null")
    @Column(unique = true)
    private String email;
}
