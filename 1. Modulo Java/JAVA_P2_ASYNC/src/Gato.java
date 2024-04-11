public class Gato extends Animal{
    private String nombre;
    

    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public void hacerSonido() {
        System.out.println("MIAU!");
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un gato que maulla.");
    }
    
}

