package org.example;

class Categoria {
    String id;
    String nombre;
    String descripcion;
    int precioMayor;
    int precioMenor;

    public Categoria(String id, String nombre, String descripcion, int precioMayor, int precioMenor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMayor = precioMayor;
        this.precioMenor = precioMenor;
    }

    public int valor(int edad){
        return edad >= 18 ? precioMayor : precioMenor;
    }
}
