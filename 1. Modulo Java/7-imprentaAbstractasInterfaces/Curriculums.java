import java.util.List;
import java.util.stream.Collectors;

public class Curriculums {

    private String nombreApellido;
    private int edad;
    private int dni;
    private char genero;
    private String tituloAcademico;
    private List<String> habilidades;


    public Curriculums() {
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    //se emplea toString para facilitar la impresion en el metodo utilitario
    public String toString() {
        String impresion = ("Curriculum:   " + "Nombre y Apellido='" + nombreApellido + '\'' +
                ", Edad=" + edad +
                ", DNI=" + dni +
                ", Genero=" + genero +
                ", Titulo Academico='" + tituloAcademico + '\'');

        String cadenaHabilidades = habilidades.stream().collect(Collectors.joining("  "));
        return impresion + " Habilidades= " + cadenaHabilidades;

    }
}
