package com.example.registeremployee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {
    @Id
    private String id;

    private String name;

    public EmploymentType(String name) {
        this.name = name;
    }
}
