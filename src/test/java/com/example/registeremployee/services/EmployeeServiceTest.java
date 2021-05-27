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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    EmployeeService service;

    @Mock
    EmployeeRepository mockRepository;

    @Mock
    EmploymentTypeRepository mockTypeRepository;

    @BeforeEach
    public void init() {
        service = new EmployeeService(mockRepository, mockTypeRepository);
    }

    @Test
    void findAll() {
        Employee mockEmployee = new Employee();
        mockEmployee.setFirstName("Ivona");
        mockEmployee.setLastName("Zoricic");
        mockEmployee.setGender("kvinna");
        mockEmployee.setSocialSecurityNr("8307084445");
        mockEmployee.setSalary(35000);
        mockEmployee.setEmploymentType(new EmploymentType("Utvecklare"));

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockEmployee));

        List<Employee> actual = service.findAll();

        assertEquals(mockEmployee.getFirstName(), actual.get(0).getFirstName());
        assertEquals(mockEmployee.getLastName(), actual.get(0).getLastName());
        assertEquals(mockEmployee.getGender(), actual.get(0).getGender());
        assertEquals(mockEmployee.getSocialSecurityNr(), actual.get(0).getSocialSecurityNr());
        assertEquals(mockEmployee.getSalary(), actual.get(0).getSalary());
        assertEquals(mockEmployee.getEmploymentType(), actual.get(0).getEmploymentType());

        verify(mockRepository).findAll();

    }

    @Test
    void addEmployee() {
        Employee expected = new Employee();
        expected.setFirstName("Ivona");
        expected.setLastName("Zoricic");
        expected.setGender("kvinna");
        expected.setSocialSecurityNr("8307084445");
        expected.setSalary(35000);

        EmploymentType expectedType = new EmploymentType("Utvecklare");
        expected.setEmploymentType(expectedType);

        when(mockRepository.findBySocialSecurityNr(anyString())).thenReturn(java.util.Optional.of(expected));
        when(mockTypeRepository.findByName(anyString())).thenReturn(java.util.Optional.of(expectedType));

        service.addEmployee(expected);

        verify(mockRepository, times(1)).findBySocialSecurityNr(anyString());
        verify(mockTypeRepository, times(1)).findByName(anyString());


    }
}