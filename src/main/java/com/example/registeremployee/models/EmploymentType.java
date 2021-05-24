package com.example.registeremployee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {

    private String id;

    private String name;

    public EmploymentType(String name) {
        this.name = name;
    }
}
