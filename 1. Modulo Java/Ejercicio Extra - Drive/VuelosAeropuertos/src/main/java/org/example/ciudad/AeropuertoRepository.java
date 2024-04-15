package org.example.ciudad;

import java.util.ArrayList;
import java.util.List;

public class AeropuertoRepository {
    private List<Aeropuerto> aeropuertoList;

    public AeropuertoRepository(){
        this.aeropuertoList = new ArrayList<>();
    }

    public List<Aeropuerto> getAeropuertosPorCiudad(Ciudad ciudad){
        return this.aeropuertoList.stream().filter(aer -> aer.getCiudad().getName().equals(ciudad.getName())).toList();
    }

}
