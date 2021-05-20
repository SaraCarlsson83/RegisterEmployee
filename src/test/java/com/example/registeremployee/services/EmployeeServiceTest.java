package com.example.registeremployee.services;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmployeeRepository;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    EmployeeService employeeService;

    @Mock
    EmployeeRepository mockEmployeeRepository;

    @Mock
    EmploymentTypeRepository mockTypeRepository;

    @BeforeEach
    void init(){
        employeeService = new EmployeeService(mockEmployeeRepository, mockTypeRepository);
    }

    
    @Test
    void updateEmployee(){
        System.out.println("i test");
        Employee expectedBefore = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 35000);
        Employee expectedAfter = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 45000);

        when(mockEmployeeRepository.findBySocialSecurityNr(anyString())).thenReturn(java.util.Optional.of(expectedBefore));

        Employee actual = employeeService.updateEmployee(expectedAfter);

        assertEquals(expectedBefore, actual);
    }
}