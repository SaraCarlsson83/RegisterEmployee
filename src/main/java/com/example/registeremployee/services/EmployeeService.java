package com.example.registeremployee.services;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmployeeRepository;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmploymentTypeRepository typeRepository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public String addEmployee(Employee employee) {
        Optional<EmploymentType> type = typeRepository.findByName(employee.getEmploymentType().getName());

        if (type.isEmpty()){
            EmploymentType newType = new EmploymentType(employee.getEmploymentType().getName());
            typeRepository.save(newType);
           employee.setEmploymentType(typeRepository.findByName(employee.getEmploymentType().getName()).orElseThrow());
        }
        else {
            employee.setEmploymentType(type.orElseThrow());
        }


        Optional<Employee> temp = repository.findBySocialSecurityNr(employee.getSocialSecurityNr());
        if(temp.isEmpty()){
            repository.save(employee);
            return employee.getFirstName() +  " " +  employee.getLastName() + " är sparad.";
        }
        else
            return "Den personen är redan registrerad";
    }

    public List<Employee> findEmployee (String firstName, String lastName){
        return repository.findEmployeeByFirstNameAndLastName(firstName, lastName);
    }

    public Employee findEmployeeBySocialSecurityNr (String socialSecurityNr){
        Optional<Employee> temp = repository.findBySocialSecurityNr(socialSecurityNr);
        return temp.orElseThrow();
    }

    public List<Employee> getAllEmployeesByType(String type){
        return repository.findAll().stream()
                .filter(f -> f.getEmploymentType().getName().equals(type))
                .collect(Collectors.toList());
    }

    public String deleteEmployee(String socialSecurityNr){
        repository.deleteBySocialSecurityNr(socialSecurityNr);
        return "Du har raderat anställd med personnummer " + socialSecurityNr;
    }

    public Employee updateEmployee (Employee employee) {
        repository.findBySocialSecurityNr(employee.getSocialSecurityNr())
                .ifPresent(user -> {
                    user.setFirstName(employee.getFirstName())
                            .setLastName(employee.getLastName())
                            .setGender(employee.getGender())
                            .setSalary(employee.getSalary())
                            .setEmploymentType(whichType(employee));
                    repository.save(user);
                } );
        return repository.findBySocialSecurityNr(employee.getSocialSecurityNr())
                .orElseThrow();
    }

    private EmploymentType whichType(Employee employee) {
        Optional<EmploymentType> type = typeRepository.findByName(employee.getEmploymentType().getName());
        if (type.isEmpty()){
            typeRepository.save(new EmploymentType(employee.getEmploymentType().getName()));
            return typeRepository.findByName(employee.getEmploymentType().getName()).orElseThrow();

        }
        else {
            return type.orElseThrow();
        }
           }



}
