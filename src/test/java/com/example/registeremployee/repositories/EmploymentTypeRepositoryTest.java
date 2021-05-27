package com.example.registeremployee.repositories;

import com.example.registeremployee.models.EmploymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class EmploymentTypeRepositoryTest {

    @Autowired
    EmploymentTypeRepository repository;

    @Test
    void deleteByName() {
        String name = "Läkare";
        EmploymentType expected = new EmploymentType("Läkare");

        repository.save(expected);
        repository.deleteByName("Läkare");


        Optional<EmploymentType> actual = repository.findByName("Läkare");

        assertTrue(actual.isEmpty());

    }

    @Test
    void findByName() {
        String name = "Sjuksköterska";
        EmploymentType expected  = new EmploymentType("Sjuksköterska");
        repository.save(expected);

        Optional<EmploymentType> actual = repository.findByName("Sjuksköterska");

        assertEquals(expected, actual.orElseThrow());


    }
}


