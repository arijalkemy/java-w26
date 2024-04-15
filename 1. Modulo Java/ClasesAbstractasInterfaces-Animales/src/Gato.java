public class Gato extends Animal implements ICarnivoro{
    public Gato() {
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }
}
