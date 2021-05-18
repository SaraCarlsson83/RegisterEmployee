package com.example.registeremployee.controllers;

import com.example.registeremployee.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @GetMapping("")
    public List<Employee> getAll(){

    }

    @PostMapping("/save")
    public String addEmployee(@RequestBody Employee employee){

    }

    @GetMapping("/findByName")
    public List<Employee> getByName(@RequestParam String name){

    }

    @GetMapping("/findById")
    public Employee getById(@RequestParam Long id){

    }

    @GetMapping("/findByType")
    public List<Employee> getByType(@RequestParam String type){

    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long id){

    }

    @PostMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){

    }

}
