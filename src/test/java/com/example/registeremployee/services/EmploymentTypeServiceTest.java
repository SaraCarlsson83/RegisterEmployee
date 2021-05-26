package com.example.registeremployee.services;

import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class EmploymentTypeServiceTest {
    @Autowired
    EmploymentTypeRepository typeRepository;

    @Test
    void deleteType() {
        EmploymentType expected = new EmploymentType("Undersköterska");
        typeRepository.save(expected);

        EmploymentType actual =typeRepository.deleteByName("Undersköterska");
        assertEquals(actual,expected);

    }
}
