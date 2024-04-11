package ejercicio3;

public class Perro extends Animal implements Carnivoro{

    public Perro() {
    }

    public void emitirSonido() {
        System.out.println("Woof");
    }

    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
