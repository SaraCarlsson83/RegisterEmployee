package com.example.registeremployee.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
            @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private EmploymentType employmentType;
    //private String department;
}
