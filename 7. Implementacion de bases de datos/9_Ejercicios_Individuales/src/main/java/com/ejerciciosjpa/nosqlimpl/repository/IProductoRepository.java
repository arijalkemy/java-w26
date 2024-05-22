package com.ejerciciosjpa.nosqlimpl.repository;

import com.ejerciciosjpa.nosqlimpl.domain.Producto;
import com.ejerciciosjpa.nosqlimpl.dto.ProductoRequestDto;
import com.ejerciciosjpa.nosqlimpl.dto.ProductoResponseDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto,String> {
    List<Producto> findAll();
}
