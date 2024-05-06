package com.viajescuidados.services.utils.ubicaciones;

import com.viajescuidados.entities.ubicaciones.Ubicacion;

public interface ICalculadoraDemora {
    Long calcularDemoraEntre(Ubicacion origen, Ubicacion destino);
}
