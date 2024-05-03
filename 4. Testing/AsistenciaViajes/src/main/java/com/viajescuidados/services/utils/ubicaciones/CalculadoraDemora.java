package com.viajescuidados.services.utils.ubicaciones;

import com.viajescuidados.entities.ubicaciones.Ubicacion;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraDemora implements ICalculadoraDemora {

    @Override
    public Long calcularDemoraEntre(Ubicacion origen, Ubicacion destino) {
        //TO DO
        return 2L;
    }
}
