package vehiculos.hql.service;


import vehiculos.hql.dto.*;
import vehiculos.hql.model.projection.PatenteAndMarca;

import java.util.List;

public interface IVehiculoService {
    public VehiculoResponseDto saveVehiculo(VehiculoRequestDto vehiculoRequestDto);

    public SiniestroResponseDto saveSiniestro(SiniestroRequestDto siniestroRequestDto);

    public List<VehiculoResponseWithSiniestroDto> findAll();

    public List<String> getPatentes();

    public List<?> getPatentesAndMarca();
    public List<?> getPatentesModeloAndMarca();
    public List<?> getRuedas();
    public List<?> getPerdidaTotal();
}
