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
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        mockEmployee.setSocialSecurityNr("8307084445");
        mockEmployee.setSalary(35000);
        mockEmployee.setEmploymentType(new EmploymentType("Utvecklare"));

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockEmployee));

        List<Employee> actual = service.findAll();

        assertEquals(mockEmployee.getFirstName(), actual.get(0).getFirstName());
        assertEquals(mockEmployee.getLastName(), actual.get(0).getLastName());
        assertEquals(mockEmployee.getSocialSecurityNr(), actual.get(0).getSocialSecurityNr());
        assertEquals(mockEmployee.getSalary(), actual.get(0).getSalary());
        assertEquals(mockEmployee.getEmploymentType(), actual.get(0).getEmploymentType());

        verify(mockRepository).findAll();
        }
  
  @Test
  void updateEmployee(){
        Employee expected = new Employee("Sara", "Carlsson",
                    "830208XXXX", 35000);
        EmploymentType expectedType = new EmploymentType("Sjuksk??terska");
        expected.setEmploymentType(expectedType);

        when(mockRepository.findBySocialSecurityNr(anyString())).thenReturn(java.util.Optional.of(expected));
        when(mockTypeRepository.findByName(anyString())).thenReturn(java.util.Optional.of(expectedType));
    
     Employee actual = service.updateEmployee(expected);

        assertEquals(expected, actual);

        verify(mockRepository, times(2)).findBySocialSecurityNr(anyString());
        verify(mockTypeRepository).findByName(anyString());
  }

    
    @Test
    void deleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Ivona");
        employee.setLastName("Zoricic");
        employee.setSocialSecurityNr("123456789");
        employee.setSalary(35000);
        employee.setEmploymentType(new EmploymentType("Utvecklare"));

        service.deleteEmployee(employee.getSocialSecurityNr());

        verify(mockRepository, times(1)).deleteBySocialSecurityNr(employee.getSocialSecurityNr());
    }


    @Test
    void addEmployee() {
        Employee mockEmployee = new Employee();
        mockEmployee.setFirstName("Ivona");
        mockEmployee.setLastName("Zoricic");
        mockEmployee.setSocialSecurityNr("8307084445");
        mockEmployee.setSalary(35000);

        EmploymentType mockType = new EmploymentType("Utvecklare");
        mockEmployee.setEmploymentType(mockType);

        when(mockRepository.findBySocialSecurityNr(anyString())).thenReturn(Optional.empty());
        when(mockTypeRepository.save(any())).thenReturn(mockType);
        when(mockRepository.save(any())).thenReturn(mockEmployee);
        when(mockTypeRepository.findByName(anyString())).thenReturn(Optional.empty(), Optional.of(mockType));

        service.addEmployee(mockEmployee);

        verify(mockRepository, times(1)).findBySocialSecurityNr(anyString());
        verify(mockRepository).save(mockEmployee);
        verify(mockTypeRepository, times(2)).findByName(anyString());
        verify(mockTypeRepository).save(mockType);

    }

     
    @Test
    void findEmployee() {

        Employee expected = new Employee("Sara", "Carlsson",
                "830208XXXX", 35000);
        EmploymentType expectedType = new EmploymentType("Sjuksk??terska");
        expected.setEmploymentType(expectedType);

        
        when(mockRepository.findEmployeeByFirstNameAndLastName(anyString(), anyString()))
                .thenReturn(Collections.singletonList(expected));

        List<Employee> actual = service.findEmployee(anyString(), anyString());

        assertEquals(actual.get(0), expected);
        verify(mockRepository).findEmployeeByFirstNameAndLastName(anyString(), anyString());

  }
}


