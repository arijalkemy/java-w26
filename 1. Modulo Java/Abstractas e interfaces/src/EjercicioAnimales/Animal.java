package EjercicioAnimales;

abstract public class Animal {
    public Animal(String sonido, String name) {
        this.sonido = sonido;
        this.name = name;
    }

    protected String sonido;
    protected String name;

    public String getSonido() {
        return sonido;
    }


}
