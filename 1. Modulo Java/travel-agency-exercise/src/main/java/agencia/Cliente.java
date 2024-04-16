package agencia;

public class Cliente {
    private String dni;
    private String nombreCompleto;

    public String getDni() {
        return dni;
    }

    public Cliente(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
