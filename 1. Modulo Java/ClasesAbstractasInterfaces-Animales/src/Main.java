public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();


        perro.emitirSonidos();
        perro.comerCarne();

        gato.emitirSonidos();
        gato.comerCarne();

        vaca.emitirSonidos();
        vaca.comerHierba();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);

    }

    private static void comerAnimal(Animal animal){
        animal.comerAnimal();
    }

}