package com.example.vehiculo.service;
import com.example.vehiculo.dot.VehiculoDOT;
import com.example.vehiculo.entity.Vehiculo;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VehiculoService {
    private List<Vehiculo> vehiculos;
    @Override
    public List<VehiculoDOT> buscarUsadosNoServices(){
        return null;
    }
    public List<Vehiculo> buscarTodos(){
        return vehiculos;
    }
 }
