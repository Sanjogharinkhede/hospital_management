package com.project.hospital_management.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EncounterId;

    @NotBlank(message = "Cause can't be Blank")
    @NotNull(message = "Cause can't be Null")
    private String cause;
    @Min(value = 0)
    private double cost;


    @ManyToOne
    private Person person;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Branch> branchs;

}
