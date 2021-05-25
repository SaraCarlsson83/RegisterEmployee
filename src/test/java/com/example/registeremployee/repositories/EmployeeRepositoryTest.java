package com.example.registeremployee.repositories;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class EmployeeRepositoryTest {

    @Autowired

    EmployeeRepository repository;

    @Test
    void findBySocialSecurityNr() {
        String firstName = "Ivona";
        String lastName = "Zoricic";
        String gender = "Kvinna";
        String sSNr = "8307084445";
        double salary = 35000;
        EmploymentType type = new EmploymentType("Läkare");

        Employee expected = new Employee();
        expected.setFirstName(firstName);
        expected.setLastName(lastName);
        expected.setGender(gender);
        expected.setSocialSecurityNr(sSNr);
        expected.setSalary(salary);
        expected.setEmploymentType(type);

        repository.save(expected);

        Optional<Employee> actual = repository.findBySocialSecurityNr("8307084445");

        assertEquals(expected, actual.orElseThrow());

    }

    @Test
    void deleteBySocialSecurityNr() {
        Employee expectedBeforeDelete = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 35000);
        expectedBeforeDelete.setEmploymentType(new EmploymentType("Undersköterska"));
        repository.save(expectedBeforeDelete);

        repository.deleteBySocialSecurityNr("830208XXXX");

        Optional<Employee> actual = repository.findBySocialSecurityNr("830208XXXX");

        assertTrue(actual.isEmpty());


        assertEquals(actual.get(0), expected);



    }



}