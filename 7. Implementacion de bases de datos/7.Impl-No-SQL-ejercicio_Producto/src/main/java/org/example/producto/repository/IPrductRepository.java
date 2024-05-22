package org.example.producto.repository;

import org.example.producto.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrductRepository extends ElasticsearchRepository<Producto, String>{
}
