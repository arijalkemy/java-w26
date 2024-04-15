public class Cliente {

    private String Nombre;
    private String Apellido;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    private String Dni;

    public Cliente(String nombre, String apellido, String dni) {
        Nombre = nombre;
        Apellido = apellido;
        Dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente\n{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Dni='" + Dni + '\'' +
                '}'+"\n";
    }
}
