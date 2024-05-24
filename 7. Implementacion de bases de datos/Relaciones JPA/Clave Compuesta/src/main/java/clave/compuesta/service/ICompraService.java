package clave.compuesta.service;

import clave.compuesta.dto.CompraRequestDto;
import clave.compuesta.dto.CompraResponseDto;

import java.util.List;

public interface ICompraService {
    CompraResponseDto saveCompra(CompraRequestDto compraRequestDto);
    List<CompraResponseDto> findAll();
}
