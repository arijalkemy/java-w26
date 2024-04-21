package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.implementation;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity.Plato;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.IPlatoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    List<Plato> platos;

    public PlatoRepositoryImpl() {
        platos = new ArrayList<>() {{
            add(new Plato("Pizza",
                    new ArrayList<>() {{
                        add("Aceitunas verdes");
                        add("Queso mozzarella");
                        add("Salsa de tomate en conserva");
                    }}
            ));
            add(new Plato("Ensalada",
                    new ArrayList<>() {{
                        add("Lechuga");
                        add("Pepino");
                        add("Tomates");
                    }}
            ));
        }};
    }

    public List<String> findIngredientes(String nombre) {
        List<String> ingredientes = null;
        for(Plato plato : platos) {
            if(plato.getName().equalsIgnoreCase(nombre)) {
                return plato.getIngredientes();
            }
        }
        return ingredientes;
    }
}
