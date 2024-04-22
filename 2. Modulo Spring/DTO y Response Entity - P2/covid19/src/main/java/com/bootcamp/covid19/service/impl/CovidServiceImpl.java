package com.bootcamp.covid19.service.impl;

import com.bootcamp.covid19.dto.RiskPersonDTO;
import com.bootcamp.covid19.entity.Consulta;
import com.bootcamp.covid19.entity.Enfermedad;
import com.bootcamp.covid19.entity.Pacientes;
import com.bootcamp.covid19.entity.Sintoma;
import com.bootcamp.covid19.service.ICovidService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidServiceImpl implements ICovidService {

    Enfermedad enfermedad = new Enfermedad();
    Pacientes pacientes = new Pacientes();

    List<Consulta> bdConsultas = List.of(
            new Consulta(pacientes.getPersonas().get(0), List.of(enfermedad.getSintomas().get(0), enfermedad.getSintomas().get(2))),
            new Consulta(pacientes.getPersonas().get(1), List.of(enfermedad.getSintomas().get(1),enfermedad.getSintomas().get(3))),
            new Consulta(pacientes.getPersonas().get(2), List.of(enfermedad.getSintomas().get(2))),
            new Consulta(pacientes.getPersonas().get(3), List.of(enfermedad.getSintomas().get(3))),
            new Consulta(pacientes.getPersonas().get(4), List.of(enfermedad.getSintomas().get(0)))
    );

    @Override
    public List<Sintoma> findAllSymptoms() {
        return enfermedad.getSintomas();
    }
    @Override
    public Sintoma findSymptomByName(String name) {
        return enfermedad.getSintomas()
                .stream()
                .filter(sintoma -> sintoma.getNombre().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<RiskPersonDTO> findRiskPerson() {
        List<RiskPersonDTO> riskPersonList = new ArrayList<>();
        bdConsultas.forEach(consulta -> {
            if(consulta.getPersona().getEdad()>=60 && consulta.getSintomas()!= null){
                riskPersonList.add(new RiskPersonDTO(consulta));
            }
        });
        return riskPersonList;
    }


}
