package com.Metricas_cores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ejercicio_1 {
    private IEjercicio_1 iEjercicio1;

    public Ejercicio_1(IEjercicio_1 iEjercicio1) {
        this.iEjercicio1 = iEjercicio1;
    }

    public List<Map<String, String>> getUsersByCountry(String country) {
        List<Map<String, String>> users = new ArrayList<>();
        try {
            // Asumimos que las claves en el KVS tienen un formato que incluye el país, por ejemplo: "user123|Spain"
            Set<String> keys = iEjercicio1.keys("*|" + country);
            for (String key : keys) {
                Map<String, String> userData = iEjercicio1.get(key);
                users.add(userData);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener usuarios del país " + country + ": " + e.getMessage());
        }
        return users;
    }
}
