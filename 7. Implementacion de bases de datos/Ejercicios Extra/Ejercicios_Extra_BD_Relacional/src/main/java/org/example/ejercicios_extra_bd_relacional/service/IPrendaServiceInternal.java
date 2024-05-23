package org.example.ejercicios_extra_bd_relacional.service;

import org.example.ejercicios_extra_bd_relacional.model.Prenda;

interface IPrendaServiceInternal {
    Prenda getByIdOrThrow(Long idPrenda);
}
