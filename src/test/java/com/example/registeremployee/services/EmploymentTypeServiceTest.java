package com.example.registeremployee.services;

import com.example.registeremployee.models.EmploymentType;
import com.example.registeremployee.repositories.EmploymentTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmploymentTypeServiceTest {

    EmploymentTypeService service;

    @Mock
    EmploymentTypeRepository mocktypeRepository;

    @BeforeEach
    public void init() {
        service = new EmploymentTypeService(mocktypeRepository);
    }

    @Test
    void addType() {
        EmploymentType mockType = new EmploymentType("Lärare");

        when(mocktypeRepository.findByName(anyString())).thenReturn(Optional.empty());
        when(mocktypeRepository.save(any())).thenReturn(mockType);

        service.addType(mockType);

        verify(mocktypeRepository, times(1)).findByName(anyString());
        verify(mocktypeRepository).save(mockType);
    }


    @Test
    void deleteType() {
        EmploymentType type = new EmploymentType("Undersköterska");

        service.deleteType(type.getName());

        verify(mocktypeRepository, times(1)).deleteByName(type.getName());

    }
}
