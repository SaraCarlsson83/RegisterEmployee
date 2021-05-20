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
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
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
    void findEmployee() {
        Employee expected = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 35000);
        expected.setEmploymentType(new EmploymentType("Undersköterska"));

        when(mockEmployeeRepository.findEmployeeByFirstNameAndLastName(anyString(), anyString()))
                .thenReturn(Collections.singletonList(expected));

        List<Employee> actual = employeeService.findEmployee(anyString(), anyString());

        assertEquals(actual.get(0), expected);
        verify(mockEmployeeRepository).findEmployeeByFirstNameAndLastName(anyString(), anyString());

    }
    
    @Test
    void updateEmployee(){

    }
}