package meli.bootcamp.hql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
}
