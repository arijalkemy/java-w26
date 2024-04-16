package com.ejercicios.fechanacimiento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class FechaController {
    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer calcularFecha(@PathVariable Integer dia,
                                 @PathVariable Integer mes,
                                 @PathVariable Integer anio){
        LocalDate fecha = LocalDate.of(anio,mes,dia);
        return Period.between(fecha,LocalDate.now()).getYears();
    }
}

public class ClienteDTO implements Serializable {
    private Long id;
    private String nombre;
    private String pais;
    private String direccion;
}

@GetMapping(path = "/{clienteId}")
@ResponseBody
public Cliente getCliente(@PathVariable Long clienteId){
    Cliente cliente = new Cliente();
    Direccion direccion = new Direccion();

    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setDireccion(direccion.getDireccion());
    clienteDTO.setPais(direccion.getPais());
    clienteDTO.setNombre(cliente.getName() + " " + cliente.getApellido());
    clienteDTO.setId(customer.getId());

    return costumerDTO;
}

