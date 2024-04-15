package punto3;
public class Vaca extends Animal implements Herviboro {
    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }

    @Override
    public void sonido() {
        System.out.println("La vaca hace muu");
    }
}