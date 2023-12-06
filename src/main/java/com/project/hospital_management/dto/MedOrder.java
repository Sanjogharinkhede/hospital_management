package com.project.hospital_management.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int orderId;
    
    
    private Date date ;
    @NotBlank(message = "Doctor can't be Blank")
    @NotNull(message = "Doctor can't be Null")
    private String doctor;
    @ManyToOne
    private Encounter encounter;
}
