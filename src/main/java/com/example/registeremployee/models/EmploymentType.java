package com.example.registeremployee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {
    @Id
    @GeneratedValue
    private String id;

    @Column(unique = true)
    private String name;

    public EmploymentType(String name) {
        this.name = name;
    }
}
