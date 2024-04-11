public class Cow extends Animal implements Herviboro{


    @Override
    public void emitSound() {
        System.out.println("Muuu");
    }


    @Override
    public void eatPlants() {
        System.out.println("La vaca come plantas");
    }
}
