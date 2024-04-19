package EjercicioAnimales;

public class Vaca extends Animal implements IHerviboro{

    public Vaca(String sonido, String name) {
        super(sonido,name);
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba");
    }
}
