package com.autos.concesionaria.service;

import com.autos.concesionaria.dto.VehiculoDTO;
import com.autos.concesionaria.entity.Vehiculo;
import com.autos.concesionaria.repository.IRepositorioVehiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    IRepositorioVehiculos repositorioVehiculos;


    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        repositorioVehiculos.agregarVehiculo(vehiculo);
    }

    @Override
    public List<VehiculoDTO> mostrarVehiculosUsados() {
        List<VehiculoDTO> listaVehiculosDTO = new ArrayList<>();
        List<Vehiculo> listaUsados = new ArrayList<>();

        //filtro autos usados
        listaUsados = repositorioVehiculos.mostrarListaVehiculos().stream()
                .filter(v -> v.getKilometros()>0)
                .toList();

        listaUsados.forEach(v -> listaVehiculosDTO.add(new VehiculoDTO(v.getId(),v.getMarca(), v.getModelo(),
                v.getFechaManufactura(), v.getKilometros(), v.getPuertas(), v.getPrecio(),
                v.getDivisa(), v.getCantidadPropietarios())));

        return listaVehiculosDTO;
    }

    @Override
    public List<Vehiculo> mostrarVehiculoPorFecha(LocalDate inicio, LocalDate fin) {
        List<Vehiculo> listaFecha = new ArrayList<>();

        //filtro los vehiculos que cumplen los requerimientos
        listaFecha = repositorioVehiculos.mostrarListaVehiculos().stream()
                .filter(v -> (v.getFechaManufactura().isAfter(inicio) && v.getFechaManufactura().isBefore(fin)))
                .toList();

        return listaFecha;
    }

    @Override
    public List<Vehiculo> mostrarVehiculoPorPrecio(Integer inicio, Integer fin) {
        List<Vehiculo> listaPrecio = new ArrayList<>();

        //filtro los vehiculos que cumplen los requerimientos
        listaPrecio = repositorioVehiculos.mostrarListaVehiculos().stream()
                .filter(v -> (v.getPrecio() > inicio) && (v.getPrecio() < fin))
                .toList();

        return listaPrecio;
    }

    @Override
    public Vehiculo mostrarVehiculoPorId(Integer id) {

        //busco vehiculo por id
        Vehiculo vehiculo = repositorioVehiculos.mostrarListaVehiculos().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
        return vehiculo;
    }
}
