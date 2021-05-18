package com.example.registeremployee.repositories;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentTypeRepository extends MongoRepository<EmploymentType, Long> {

    EmploymentType findByName(String name);
    void deleteByName(String name);
}
