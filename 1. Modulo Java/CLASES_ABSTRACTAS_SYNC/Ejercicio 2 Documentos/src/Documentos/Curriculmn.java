package Documentos;
import java.util.List;

public class Curriculmn implements IDocumento {
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> habilidades; 
    

    
    public Curriculmn(String nombre, String apellido, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    

    @Override
    public String toString() {
        return "Curriculmn [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", habilidades="
                + habilidades + "]";
    }



    @Override
    public void imprimir() {
        System.out.println(this.toString()); 
    }

}
