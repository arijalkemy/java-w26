package org.example.ejercicios_extra_elasticsearch.service;

import org.example.ejercicios_extra_elasticsearch.model.Prenda;

interface IPrendaServiceInternal {
    Prenda getByIdOrThrow(String idPrenda);
}
