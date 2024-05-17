package org.bootcamp.numerosromanos.service;

import org.bootcamp.numerosromanos.repository.INumerosRomanosRepository;
import org.bootcamp.numerosromanos.repository.INumerosRomanosRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class ConversorNumerosServiceImpl implements IConversorNumerosService {

    private INumerosRomanosRepository nrRomanosRepository;


    public ConversorNumerosServiceImpl() {
      nrRomanosRepository= new INumerosRomanosRepositoryImpl();
    }

    public String convertirNroDecimalARomano(Integer numeroDecimal) {
       return nrRomanosRepository.convertirNroDecimalARomano(numeroDecimal);
    }
    public Integer convertirNroRomanoADecimal(String numeroRomano) {
        return nrRomanosRepository.convertirNroRomanoADecimal(numeroRomano);
    }

    }
