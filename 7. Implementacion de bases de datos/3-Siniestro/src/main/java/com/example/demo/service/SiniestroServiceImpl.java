package com.example.demo.service;
import com.example.demo.dto.SiniestroDTO;
import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.VehiculoSiniestroDTO;
import com.example.demo.repository.ISiniestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    @Autowired
    private ISiniestroRepository siniestroRepository;

    /*
    public SiniestroDTO crearSiniestro(SiniestroDTO siniestroDTO) {
        return null;
    }

    public SiniestroDTO obtenerSiniestroPorId(int id) {
        return null;
    }

     */

    @Override
    public List<VehiculoDTO> listarPerdidaMayor10000() {
        List<Object[]> resultados = siniestroRepository.findPerdidaMayor10000();
        List<VehiculoDTO> vehiculos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            VehiculoDTO vehiculoDTO = new VehiculoDTO(
                    (String) resultado[0],
                    (String) resultado[1],
                    (String) resultado[2]
            );
            vehiculos.add(vehiculoDTO);
        }
        return vehiculos;
    }

    @Override
    public List<VehiculoSiniestroDTO> listarPerdidaMayor10000Total() {
        List<Object[]> resultados = siniestroRepository
                .findPerdidaMayor10000Total();
        List<VehiculoSiniestroDTO> vehiculos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            VehiculoDTO vehiculoDTO = new VehiculoDTO(
                    (String) resultado[0],
                    (String) resultado[1],
                    (String) resultado[2]
            );
            double perdida = (Double) resultado[3];
            VehiculoSiniestroDTO vehiculoSiniestroDTO = new VehiculoSiniestroDTO(vehiculoDTO, perdida);
            vehiculos.add(vehiculoSiniestroDTO);
        }
        return vehiculos;
    }

}
