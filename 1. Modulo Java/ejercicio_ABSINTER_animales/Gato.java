public class Gato extends Animal implements Carnivoro{
    @Override
    void hacerSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne.");
    }
}
