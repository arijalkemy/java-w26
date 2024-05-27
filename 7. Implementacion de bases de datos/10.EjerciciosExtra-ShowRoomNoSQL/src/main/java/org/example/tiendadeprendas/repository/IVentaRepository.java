package org.example.tiendadeprendas.repository;

import org.example.tiendadeprendas.model.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends ElasticsearchRepository<Venta, String> {
    Venta findVentaByIdVenta(String code);
    List<Venta> findAllByFecha(LocalDate fecha);
}
