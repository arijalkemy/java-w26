import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Impresora{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo CV");
        System.out.println("Persona: " + persona.getNombre());
        for (String habilidad: habilidades){
            System.out.println("Imprimiendo habilidad " + habilidad);
        }
    }
}
