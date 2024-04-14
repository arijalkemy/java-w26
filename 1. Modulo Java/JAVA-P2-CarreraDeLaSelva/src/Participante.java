public class Participante {

    private static int contadorId;
    private int id;

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long celular;
    private String grupoSanguineo;

    public Participante(String dni, String nombre, String apellido, int edad, long celular, String grupoSanguineo) {
        this.id = this.contadorId;
        contadorId++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.grupoSanguineo = grupoSanguineo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
