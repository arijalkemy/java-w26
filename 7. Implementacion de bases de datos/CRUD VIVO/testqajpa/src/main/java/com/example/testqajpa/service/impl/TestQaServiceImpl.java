package com.example.testqajpa.service.impl;

import com.example.testqajpa.dto.TestcaseDTO;
import com.example.testqajpa.model.Testcase;
import com.example.testqajpa.repository.ITestRepository;
import com.example.testqajpa.service.ITestQaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestQaServiceImpl implements ITestQaService
{
    @Autowired
    ITestRepository testRepository;

    @Override
    public String crearTestQa(TestcaseDTO testcasee)
    {
        Testcase test = convertToModel(testcasee);
        testRepository.save(test);
        return "El test con id: "+test.getId_case()+" se ha creado con exito";
    }

    @Override
    public String actualizarTestQa(Long id, TestcaseDTO test) {

        Testcase testA = testRepository.findById(id).orElse(null);
        if(test == null)
            throw new RuntimeException("El test no existe");
        testA = convertToModel(test);
        testA.setId_case(id);
        testRepository.save(testA);
        return "Se ha actualizado con exito el test id: "+id;
    }

    @Override
    public String eliminarTestQa(Long id) {
        testRepository.deleteById(id);
        return "Se ha eliminado con exito el test id: "+id;
    }

    @Override
    public TestcaseDTO buscarTestQaPorId(Long id) {
        return convertToDto(testRepository.findById(id).orElse(null));
    }

    @Override
    public List<TestcaseDTO> buscarTodosLosTestQa() {
        return testRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public List<TestcaseDTO> buscarConFiltro(LocalDate fecha) {
        return testRepository.findAll().stream().filter(test -> test.getLast_update().isAfter(fecha)).map(this::convertToDto).toList();
    }

    public TestcaseDTO convertToDto(Testcase test) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(test, TestcaseDTO.class);
    }
    public Testcase convertToModel(TestcaseDTO test) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(test, Testcase.class);
    }
}
