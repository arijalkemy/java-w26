public class Perro extends Animal implements ICarnivoro{
    public Perro() {
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Guau");
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
