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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
        Employee expected = new Employee("Sara", "Carlsson", "Female",
                "830208XXXX", 35000);
        EmploymentType expectedType = new EmploymentType("Sjuksköterska");
        expected.setEmploymentType(expectedType);

        when(mockEmployeeRepository.findBySocialSecurityNr(anyString())).thenReturn(java.util.Optional.of(expected));
        when(mockTypeRepository.findByName(anyString())).thenReturn(java.util.Optional.of(expectedType));

        Employee actual = employeeService.updateEmployee(expected);

        assertEquals(expected, actual);

        verify(mockEmployeeRepository, times(2)).findBySocialSecurityNr(anyString());
        verify(mockTypeRepository).findByName(anyString());
    }
}