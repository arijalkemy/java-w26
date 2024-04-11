package org.example.ejercisio_2;

public class Curriculum implements IDocumento{
    private String nombre;
    private int edad;
    private String genero;
    private int telefono;
    private String experiencia;
    private String educacion;

    public Curriculum(String nombre, int edad, String genero, int telefono, String experiencia, String educacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.experiencia = experiencia;
        this.educacion = educacion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curriculum{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", experiencia='").append(experiencia).append('\'');
        sb.append(", educacion='").append(educacion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
