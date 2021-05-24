package com.example.registeremployee.services;

import com.example.registeremployee.models.EmploymentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2021-05-24
 * Time:
 * Project:RegisterEmployee
 * Copyright: MIT
 */
class EmployeeServiceTest {

    @Test
    void getAllEmployeesByType() {
    }

    @Test
    void addType() {
        EmploymentType type = new EmploymentType("type1");
        typeRepository.save(type).toString();
        EmploymentType actual= typeRepository.findAll().get(0);

        assertEquals(actual,type);

    }

    @Test
    void deleteType() {
        EmploymentType expected = new EmploymentType("");
        expected.setName("Undersköterska");
        typeRepository.save(expected);

        typeRepository.deleteByName("Undersköterska");

        //Optional<EmploymentType> actual = typeRepository.deleteByName("");

        // assertTrue(actual.isEmpty());
    }
}