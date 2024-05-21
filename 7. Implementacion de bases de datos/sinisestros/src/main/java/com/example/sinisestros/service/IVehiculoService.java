package com.example.sinisestros.service;

import com.example.sinisestros.dto.ListPatentesDTO;
import com.example.sinisestros.dto.ListPatentesyMarcasDTO;

public interface IVehiculoService {
    ListPatentesDTO getAllPatentes();
    ListPatentesyMarcasDTO getAllPatentesYMarcas ();

    ListPatentesDTO getPatentesMasDeCuatroRuedasAnioActual();
}
