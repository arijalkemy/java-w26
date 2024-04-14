public class Main {
    public static void main(String[] args) {

        Animal animal1 = new Gato();
        Animal animal2 = new Perro();
        Animal animal3 = new Vaca();

        animal1.emitirSonido();
        animal2.emitirSonido();
        animal3.emitirSonido();

        animal1.comerAnimal();
        animal2.comerAnimal();
        animal3.comerAnimal();
    }
}
