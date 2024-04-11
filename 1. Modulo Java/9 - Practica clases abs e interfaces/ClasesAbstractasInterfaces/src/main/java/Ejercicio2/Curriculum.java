package Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible {

    List<String> habilidades;
    Persona persona;

    public Curriculum( Persona persona ){
        this.persona = persona;
        habilidades = persona.getHabilidades();
    }

    @Override
    public void imprimir() {
        System.out.println(persona.toString());

        habilidades.stream().forEach(System.out::println);

    }
}
