package com.example.registeremployee.services;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class EmployeeServiceTest2 {

    @Autowired
    EmployeeRepository repository;

    @Test
    void findEmployeeBySocialSecurityNr() {

        Employee expected = new Employee();
        expected.setFirstName("Abel");
        expected.setLastName("Shif");
        expected.setSocialSecurityNr("6777658888");
        expected.setSalary(26000.0);
        expected.setEmploymentType(new EmploymentType("Sjuksköterska"));

        repository.save(expected);

        Optional<Employee> actual = repository.findBySocialSecurityNr("6777658888");

        assertEquals(expected, actual.orElseThrow());


    }
}