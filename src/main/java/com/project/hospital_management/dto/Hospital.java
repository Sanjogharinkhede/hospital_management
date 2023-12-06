package com.project.hospital_management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Hospital {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int HospitalId;
    
    @NotBlank(message = "Name can't be blank")
    @NotNull(message = "Name can't be null")
    private String name;

    private String ceo;

    
    @NotBlank(message = "Email can't be blank")
    @NotNull(message = "Email can't be null")
    @Email(regexp = "[a-zA-Z0-9?.$]+@[a-zA-Z]+.[a-z]{2,3}",message = "Email incorrect!!")
    @Column(unique = true)
    private String email;

}
