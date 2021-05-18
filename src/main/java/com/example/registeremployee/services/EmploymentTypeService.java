package com.example.registeremployee.services;


import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmploymentTypeService {

    private final EmploymentTypeRepository repository;

    public List<EmploymentType> findAll() {
        return repository.findAll();
    }

    public String addType(EmploymentType employmentType) {
        EmploymentType temp = repository.findByName(employmentType.getName());
        if(temp==null){
            repository.save(employmentType);
            return employmentType.getName() +  " är sparad.";
        }
        else
            return "Den anställningstyp finns redan";
    }

    public String deleteType(Long id){
        repository.deleteById(id);
        return "Du har raderat anställningstyp med id " + id;
    }

}
