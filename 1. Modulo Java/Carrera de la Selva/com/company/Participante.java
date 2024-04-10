package com.company;

public class Participante {
    private final String grupoSanguineo;
    private final String numeroEmergencia;
    private final String celular;
    private final int edad;
    private final String apellido;
    private final String nombre;
    private final String dni;
    private final int numero;
    private Categoria categoria;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = null;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getCelular() {
        return celular;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getNumero() {
        return numero;
    }

    public int recordInscriptionTo(Categoria categoria) {
        if(this.getEdad() >= 18){
            return categoria.getCostoMayor();
        } else{
            return categoria.getCostoMenor();
        }
    }

    public void asignarCategoria(Categoria categoria) {
        if(this.categoria != null){
            this.categoria.desuscribir(this);
        }
        this.categoria = categoria;
    }

    public int cuantoAbona() {
        return categoria.getCostoFor(this);
    }

    public String infoDeParticipante() {
        return "Nombre Completo: " + nombre + " " + apellido + ",\nDNI: " + dni + ",\nNúmero: " + numero + ",\nEdad: " + edad + ",\nCelular: " + celular + ",\nN° de Emergencia: " + numeroEmergencia + ",\nGrupo Sanguíneo: " + grupoSanguineo;
    }

    public void dejarSinCategoria() {
        this.categoria = null;
    }
}
