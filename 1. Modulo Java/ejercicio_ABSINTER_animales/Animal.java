abstract class Animal {
    abstract void hacerSonido();

    void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no come carne ni hierba.");
        }
    }
}
