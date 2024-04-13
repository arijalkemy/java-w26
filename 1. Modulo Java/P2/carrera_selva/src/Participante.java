public class Participante {
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private Categoria categoria;
    private int id;

    void setId(int id){
        this.id = id;
    }
    Categoria getCategoria(){
        return categoria;
    }

    void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    Participante(
            String nombre,
            String apellido,
            int edad,
            int dni,
            String celular,
            String numeroEmergencia,
            String grupoSanguineo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return " Participante{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", celular='" + celular + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", categoria=" + categoria +
                "\n" +
                '}';
    }
}
