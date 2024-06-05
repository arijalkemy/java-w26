package logica;

public class Perro extends Animal implements Carnivoro{

    public Perro() {

    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne...";
    }
}
