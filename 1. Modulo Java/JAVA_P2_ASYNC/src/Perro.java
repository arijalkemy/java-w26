public class Perro extends Animal{
    private String nombre;
    

    public Perro(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public void hacerSonido() {
        System.out.println("GUAA!");
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un perro que ladra.");
    }
    
}
