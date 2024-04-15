package org.example.vuelo;

import java.util.ArrayList;
import java.util.List;

public class VueloRepository {
    private List<Vuelo> vueloRepository;

    public VueloRepository(){
        this.vueloRepository = new ArrayList<>();
    }

    public void insertarVuelo(Vuelo vuelo){
        this.vueloRepository.add(vuelo);
    }

}
