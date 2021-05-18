package com.example.registeremployee.controllers;

import com.example.registeremployee.models.Employee;
import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.services.EmploymentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/type")
public class EmploymentTypeController {

    private final EmploymentTypeService service;

    @GetMapping("")
    public List<EmploymentType> getAll(){
        return service.findAll();
    }

    @PostMapping("/save")
    public String addType(@RequestBody EmploymentType employmentType){
        return service.addType(employmentType);
    }

    @GetMapping("/delete")
    public String deleteType(@RequestParam Long id){
        return service.deleteType(id);
    }

}
