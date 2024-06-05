package logica;

public class Gato extends Animal implements Carnivoro{

    public Gato() {

    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne...";
    }
}
