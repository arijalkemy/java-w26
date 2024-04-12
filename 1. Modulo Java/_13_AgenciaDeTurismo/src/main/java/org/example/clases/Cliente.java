package org.example.clases;

public class Cliente {
    private int dni;
    private String nombre;
    private boolean tieneEl5DeDescuentoPorTenerMasDe2Localizadores;

    public boolean isTieneEl5DeDescuentoPorTenerMasDe2Localizadores() {
        return tieneEl5DeDescuentoPorTenerMasDe2Localizadores;
    }

    public void setTieneEl5DeDescuentoPorTenerMasDe2Localizadores(boolean tieneEl5DeDescuentoPorTenerMasDe2Localizadores) {
        this.tieneEl5DeDescuentoPorTenerMasDe2Localizadores = tieneEl5DeDescuentoPorTenerMasDe2Localizadores;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public void aplicarDescuento(){
        this.tieneEl5DeDescuentoPorTenerMasDe2Localizadores = true;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", el estado del descuento es =" + tieneEl5DeDescuentoPorTenerMasDe2Localizadores +
                '}';
    }
}
