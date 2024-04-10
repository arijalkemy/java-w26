package org.example;

public class Participante {
    private Integer nro;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String celular;
    private String nroEmergencia;
    private String grupoSanguineo;

    public Participante(Integer nro, String dni, String nombre, String apellido, Integer edad, String celular, String nroEmergencia, String grupoSanguineo) {
        this.nro = nro;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
    public Integer getEdad() {
        return edad;
    }

    public Integer getNro() {
        return nro;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getNroEmergencia() {
        return nroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nro=" + nro +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", nroEmergencia='" + nroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
