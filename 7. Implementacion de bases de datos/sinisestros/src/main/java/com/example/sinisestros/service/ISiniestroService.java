package com.example.sinisestros.service;

import com.example.sinisestros.dto.VehiculoPatMarModDto;

import java.util.List;

public interface ISiniestroService {
    //listar matricula marca y modelo de todos los vehiculos con isniestro y perdida mayor a 10k
    List<VehiculoPatMarModDto> getinformacionVehiculoSiniestroMayoraDiezMil();

}
