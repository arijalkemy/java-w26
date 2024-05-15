package EjercicioDocumentos;

import java.util.List;

public class Curriculum implements Imprimible{

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", habilidades=" + habilidades.toString()+
                '}';
    }


    public Curriculum(String nombre, Integer edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    private String nombre;
    private Integer edad;
    private List<String> habilidades;



}
