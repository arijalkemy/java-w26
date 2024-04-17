package com.w26.deportista.deportistas.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Deporte {

    public enum NIVELES {
        BASICO("Básico"),
        MEDIO("Medio"),
        AVANZADO("Avanzado");

        private String valor;

        private NIVELES(String valor)
        {
            this.valor = valor;
        }

        public String getValor()
        {
            return  this.valor;
        }
    }

    private @Getter @Setter String nombre;
    private @Getter @Setter String nivel;

    public Deporte(String nombre, NIVELES nivel)
    {
        this.nombre = nombre;
        this.nivel = nivel.getValor();
    }
}

