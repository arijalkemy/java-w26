public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("El gato hace: miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne.");
    }
}