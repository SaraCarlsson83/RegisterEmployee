package com.example.registeremployee.repositories;


import com.example.registeremployee.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findBySocialSecurityNr(String socialSecurityNr);
    List<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
    void deleteBySocialSecurityNr(String socialSecurityNr);

    //Test

}
