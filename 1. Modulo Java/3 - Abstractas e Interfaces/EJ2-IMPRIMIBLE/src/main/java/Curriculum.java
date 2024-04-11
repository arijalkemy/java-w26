import java.util.ArrayList;

public class Curriculum {
    private String nombre;
    private ArrayList<String> habilidades = new ArrayList<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public Curriculum(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
