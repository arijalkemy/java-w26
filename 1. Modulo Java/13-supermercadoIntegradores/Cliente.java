public class Cliente {
    private int dni;
    private String nombreApellido;

    public Cliente() {
    }

    public Cliente(int dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @Override
    public String toString() {
        return "Cliente :" +
                "DNI=" + dni +
                ", Nombre y Apellido='" + nombreApellido + '\'';
    }
}
