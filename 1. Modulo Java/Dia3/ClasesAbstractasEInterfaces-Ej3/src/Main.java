public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        System.out.println();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        System.out.println();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
        System.out.println();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        } else {
            System.out.println("El animal es omnívoro");
        }
    }
}