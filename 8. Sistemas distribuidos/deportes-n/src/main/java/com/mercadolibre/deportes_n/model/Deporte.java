package com.mercadolibre.deportes_n.model;

import lombok.Getter;

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

    @Getter
    private String nombre;
    @Getter
    private String nivel;

    public Deporte(String nombre, NIVELES nivel)
    {
        this.nombre = nombre;
        this.nivel = nivel.getValor();
    }
}

