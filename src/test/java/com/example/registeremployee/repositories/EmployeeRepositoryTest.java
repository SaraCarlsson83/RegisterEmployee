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
    EmployeeRepository employeeRepository;

    @Test
    void deleteBySocialSecurityNr() {
        Employee expectedBeforeDelete = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 35000);
        expectedBeforeDelete.setEmploymentType(new EmploymentType("Undersköterska"));
        employeeRepository.save(expectedBeforeDelete);

        employeeRepository.deleteBySocialSecurityNr("830208XXXX");

        Optional<Employee> actual = employeeRepository.findBySocialSecurityNr("830208XXXX");

        assertTrue(actual.isEmpty());

    }


}