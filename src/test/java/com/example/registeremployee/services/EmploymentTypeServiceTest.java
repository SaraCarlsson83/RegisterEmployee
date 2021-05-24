package com.example.registeremployee.services;

import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2021-05-20
 * Time:
 * Project:RegisterEmployee
 * Copyright: MIT
 */
@DataMongoTest
class EmploymentTypeServiceTest {
    @Autowired
    EmploymentTypeRepository typeRepository;
    //EmploymentTypeService service;

    @Test
    void findAll() {
        EmploymentType expected = new EmploymentType("läkare");
        //expected.setName("Undersköterska");
        typeRepository.save(expected);
        List<EmploymentType> actual= typeRepository.findAll();
        assertEquals(actual.get(0),expected);

    }

}