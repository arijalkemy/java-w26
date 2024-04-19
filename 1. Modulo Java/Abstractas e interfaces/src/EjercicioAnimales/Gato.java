package EjercicioAnimales;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String sonido, String name) {
        super(sonido,name);
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Le da un mordisco a: "+ animal.name);
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");

    }
}
