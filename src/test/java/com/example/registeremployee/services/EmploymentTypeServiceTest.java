package com.example.registeremployee.services;

import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest

class EmploymentTypeServiceTest {

    @Autowired
    EmploymentTypeRepository typeRepository;
    EmploymentTypeService service;


    /*@AfterEach
     public  void init(){
       typeRepository.deleteByName("läkare");
    }*/
    @BeforeEach
    void init(){
        service = new EmploymentTypeService(typeRepository);
    }
    @Test
    void findAll() {

       EmploymentType employmentType = new EmploymentType("läkare");
        typeRepository.save(employmentType);

        List<EmploymentType> actual= typeRepository.findAll();
        System.out.println(employmentType.getId());

        System.out.println(actual.get(0).getId() + "-" + actual.get(0).getName());


        assertEquals(actual.get(0),employmentType);

    }
    @Test
    void addType() {

        EmploymentType employmentType = new EmploymentType("läkare");
        typeRepository.save(employmentType);

        EmploymentType actual= typeRepository.findAll().get(0);

        assertEquals(actual,employmentType);

    }
}




    


