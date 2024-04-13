public class Gato extends Animal implements IHerviboro{

    @Override
    public void emitirSonidos() {
        System.out.println("Miau! Miau!");
    }

    @Override
    public void comerHierba() {
        System.out.println("El gato esta comiendo pasto");
    }
}
