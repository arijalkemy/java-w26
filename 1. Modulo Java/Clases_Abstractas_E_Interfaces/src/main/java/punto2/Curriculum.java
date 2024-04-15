package punto2;
import java.util.List;
//Creación clase curriculum con list de habilidades
public class Curriculum implements Imprimible {
    private String nombre;
    private String email;
    private List<String> habilidades;
//Constructor de curriculum
    public Curriculum(String nombre, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.email = email;
        this.habilidades = habilidades;
    }
//Override del obtenerContenidoParaImprimir establecido en la interfaz Imprimible
    @Override
    public String obtenerContenidoParaImprimir() {
        //String.join permite listar las hibilidades establecidas en listas
        return "El nombre es: "+nombre+" - El email es: "+email+String.join(", ", habilidades);
    }
}
