package supermercado.classes;

public class Cliente {
    private String dni;

    private String nombre;

    private String apellido;

    public String getDni() {
        return dni;
    }

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente { " +
                "DNI = '" + dni + '\'' +
                ", Nombre = '" + nombre + '\'' +
                ", Apellido = '" + apellido + '\'' +
                '}';
    }
}
