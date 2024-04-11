public class Perro extends Animal implements Carnivoro{
    @Override
    void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne.");
    }
}
