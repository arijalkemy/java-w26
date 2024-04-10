package Clases;

public class Gato extends Animal{

    private String nombre;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
}
