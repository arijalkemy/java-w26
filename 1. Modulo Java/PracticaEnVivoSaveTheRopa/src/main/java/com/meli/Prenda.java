package com.meli;

/**
 * La clase Prenda representa una prenda de ropa con marca, modelo y tipo.
 */
public class Prenda {
    String marca;
    String modelo;
    String tipo;

    /**
     * Constructor de la clase Prenda.
     * @param marca La marca de la prenda.
     * @param modelo El modelo de la prenda.
     * @param tipo El tipo de la prenda.
     */
    public Prenda(String marca, String modelo, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Obtiene la marca de la prenda.
     * @return La marca de la prenda.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la prenda.
     * @param marca La nueva marca de la prenda.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo de la prenda.
     * @return El modelo de la prenda.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo de la prenda.
     * @param modelo El nuevo modelo de la prenda.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipo de la prenda.
     * @return El tipo de la prenda.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la prenda.
     * @param tipo El nuevo tipo de la prenda.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en cadena de la prenda.
     * @return Una cadena que representa la prenda.
     */
    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}