package com.project.hospital_management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @NotBlank(message = "Medicine name can't be Blank")
    @NotNull(message = "Medicine name can't be Null")
    private String medicine;
    @Min(value = 0)
    private double price;
    @ManyToOne
    private MedOrder order;
}
