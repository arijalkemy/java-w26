package logica;

public class Vaca extends Animal implements Herviboro{
    public Vaca() {

    }


    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba() {
        return "Comiendo hierba";
    }
}
