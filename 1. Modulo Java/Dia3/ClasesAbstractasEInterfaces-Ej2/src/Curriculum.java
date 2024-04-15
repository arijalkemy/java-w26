import java.util.List;

public class Curriculum {
    private String nombre;
    private int edad;
    private List<String> habilidades;

    public Curriculum() {
    }

    public Curriculum(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setNombre(String juanPerez) {
    }

    public void setEdad(int i) {
    }

    public <T> void getHabilidades(List<T> list) {
    }
}