package com.project.hospital_management.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @NotBlank(message = "Branch Name can't be Blank")
    @NotNull(message = "Branch Name can't be Null")
    private String name;

    private String manager;

   
    @ManyToOne
    private Hospital hospital;

    
    @OneToOne
    private Address address;

}
