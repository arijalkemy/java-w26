package com.mercadolibre.concesionaria.service;

import com.mercadolibre.concesionaria.dto.PatenteMarcaYModeloVehiculoDTO;
import com.mercadolibre.concesionaria.dto.PatenteVehiculoDTO;
import com.mercadolibre.concesionaria.dto.PatenteYMarcaVehiculoDTO;
import com.mercadolibre.concesionaria.dto.VehiculosConSiniestroMayorA1000;
import com.mercadolibre.concesionaria.model.Siniestro;
import com.mercadolibre.concesionaria.projections.PatenteYMarca;
import com.mercadolibre.concesionaria.projections.VehiculoConSiniestrosProjection;
import com.mercadolibre.concesionaria.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public List<PatenteVehiculoDTO> getAllPatentes() {
        return vehiculoRepository.findVehiculosConPatentes()
                .stream()
                .map(PatenteVehiculoDTO::new)
                .toList();
    }

    @Override
    public List<PatenteYMarcaVehiculoDTO> getAllPatentesYMarcas() {
        return vehiculoRepository.findVehiculosConPatentesYMarca()
                .stream()
                .map(patenteYMarca -> new PatenteYMarcaVehiculoDTO(patenteYMarca.getPatente(), patenteYMarca.getMarca()))
                .toList();
    }

    @Override
    public List<PatenteVehiculoDTO> getPatentesSegunRuedasYAnoDeFabricacion() {
        return vehiculoRepository.findPatentesSegunCantidadDeRuedasYAnoDeFabricacion()
                .stream()
                .map(PatenteVehiculoDTO::new)
                .toList();
    }

    @Override
    public List<PatenteMarcaYModeloVehiculoDTO> getVehiculosConSiniestrosMayoresA10000() {
        return vehiculoRepository.findVehiculosConSiniestrosMayoresA10000()
                .stream().map(patenteMarcaModelo -> new PatenteMarcaYModeloVehiculoDTO(patenteMarcaModelo.getPatente(),
                        patenteMarcaModelo.getMarca(),
                        patenteMarcaModelo.getModelo()))
                .toList();
    }

    @Override
    public VehiculosConSiniestroMayorA1000 getConjuntoVehiculosConSiniestrosMayoresA1000() {
        List<VehiculoConSiniestrosProjection> vehiculosProjection = vehiculoRepository.findVehiculosConSiniestrosMayoresA10000Projection();

        List<PatenteMarcaYModeloVehiculoDTO> vehiculos = vehiculosProjection
                .stream()
                .map(
                        vehiculo -> new PatenteMarcaYModeloVehiculoDTO(
                                vehiculo.getPatente(),
                                vehiculo.getMarca(),
                                vehiculo.getModelo()
                        )
                ).collect(Collectors.toList());

        // Calcular la suma de las pérdidas económicas
        Double sumaSiniestros = vehiculosProjection.stream()
                .flatMap(vehiculo -> vehiculo.getSiniestros().stream())
                .mapToDouble(Siniestro::getPerdidaEconomica)
                .sum();

        return new VehiculosConSiniestroMayorA1000(
                vehiculos,
                sumaSiniestros
        );
    }
}
