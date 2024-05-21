package com.vehiculossegurovivo.services.interfaces;

import com.vehiculossegurovivo.dtos.responses.VehiculoResponseDTO;
import com.vehiculossegurovivo.models.projections.MatriculaMarcaModelo;
import com.vehiculossegurovivo.models.projections.MatriculaMarcaModeloPerdidaTotal;
import com.vehiculossegurovivo.models.projections.PatenteMarca;

import java.util.List;

public interface IVehicleService {
    public VehiculoResponseDTO getVehiculoById(Long id);
    public List<VehiculoResponseDTO> findAll();
    // Listar las patentes de todos los vehículos registrados.
    public List<String> findAllPatentes();
    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    public List<PatenteMarca> findAllPatentesAndMarcaOrderByAnioFabricacion();
    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el
    // corriente año.
    public List<String> findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual();
    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de
    // 10000 pesos.
    public List<MatriculaMarcaModelo> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000();
    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de
    // 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    public List<MatriculaMarcaModeloPerdidaTotal> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000AndPerdidaTotal();
}
