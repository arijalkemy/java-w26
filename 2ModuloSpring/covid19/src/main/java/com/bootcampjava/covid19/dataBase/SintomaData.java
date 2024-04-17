package com.bootcampjava.covid19.dataBase;

import com.bootcampjava.covid19.model.Sintoma;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Data
public class SintomaData {
    private List<Sintoma> sintomas = new ArrayList<Sintoma>();

    public SintomaData() {
        cargarBaseDeDatos(10);
    }

    /**
     * Carga una base de datos de ejemplo de síntomas.
     *
     * @param cantidad Cantidad de síntomas a generar.
     */
    public void cargarBaseDeDatos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            sintomas.add(new Sintoma(generarCodigo(), generarNombre(), generarNivelGravedad()));
        }
    }
    // Funciones para generar datos aleatorios de síntomas
    private String generarCodigo() {
        // Generar código único aleatorio
        String codigo = "SIN-";
        codigo += String.valueOf(Math.abs(new Random().nextInt()));
        while (existeCodigo(codigo)) {
            codigo = "SIN-" + String.valueOf(Math.abs(new Random().nextInt()));
        }
        return codigo;
    }

    private boolean existeCodigo(String codigo) {
        // Verificar si el código ya existe en la lista de síntomas
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private String generarNombre() {
        // Generar nombre aleatorio de una lista de nombres predefinidos
        String[] nombresSintomas = {"Dolor de cabeza", "Fiebre", "Tos", "Dolor de garganta", "Congestión nasal",
                "Dolor muscular", "Fatiga", "Diarrea", "Náuseas", "Vómitos"};
        return nombresSintomas[new Random().nextInt(nombresSintomas.length)];
    }

    private String generarNivelGravedad() {
        // Generar nivel de gravedad aleatorio de una lista predefinida
        String[] nivelesGravedad = {"Leve", "Moderado", "Grave"};
        return nivelesGravedad[new Random().nextInt(nivelesGravedad.length)];
    }

}
