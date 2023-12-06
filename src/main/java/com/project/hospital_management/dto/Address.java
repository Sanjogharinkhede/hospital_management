package com.project.hospital_management.dto;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    
    @NotBlank(message = "City can't be Blank")
    @NotNull(message = "City can't be Null")
    private String city;
    
    private String state;
    
  
    @Min(value = 100000)
    @Max(value = 999999)
    private int pincode;
}
