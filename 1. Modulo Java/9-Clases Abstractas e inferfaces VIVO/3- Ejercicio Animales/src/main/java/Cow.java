public class Cow extends Animal implements Herviboro {

    @Override
    public void emitSound() {
        System.out.println();
    }


    @Override
    public String eatPlants() {
        return "La vaca come plantas";
    }
}
