package com.example.vehiculo.service;
import com.example.vehiculo.dot.VehiculoDOT;
import com.example.vehiculo.entity.Vehiculo;
import java.util.List;

public interface IVehiculoService {
    public List<Vehiculo> agregarVehiculo();
    public List<VehiculoDOT> buscarUsadosNoServices();
    public List<VehiculoDOT> buscarFechaFabricacion();
    public List<VehiculoDOT> buscarPrecios();
    public List<Vehiculo> buscarPorId();

}