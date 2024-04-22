package animals;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        vaca.comerHierba();
        vaca.emitirSonido();
        perro.comerCarne();
        perro.emitirSonido();
        gato.comerCarne();
        gato.emitirSonido();
        
        comerAnimal(gato);
        comerAnimal(vaca);
        comerAnimal(perro);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        }
    }
}
