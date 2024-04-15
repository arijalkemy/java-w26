package org.example;

public class Cliente {
    private String nombreCompleto;
    private String dni;
    private String domicilio;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente(String nombreCompleto, String dni, String domicilio) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Cliente:" + "\n" +
                "nombreCompleto='" + nombreCompleto + "\n" +
                "dni='" + dni + "\n" +
                "domicilio='" + domicilio + "\n";
    }
}
