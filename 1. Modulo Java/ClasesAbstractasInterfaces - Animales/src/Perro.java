public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonidos() {
        System.out.println("Guau guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne");
    }
}
