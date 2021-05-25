package com.example.registeremployee.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Employee {


    private String id;

    private String firstName;
    private String lastName;
    private String gender;


    private String socialSecurityNr;

    private double salary;

    private EmploymentType employmentType;
    //private String department;


    public Employee(String firstName, String lastName, String gender, String socialSecurityNr, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.socialSecurityNr = socialSecurityNr;
        this.salary = salary;
        this.employmentType = employmentType;
    }
}
