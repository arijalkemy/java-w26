package EjercicioAnimales;

public class Perro extends Animal implements ICarnivoro {


    public Perro(String sonido,String name) {
        super(sonido,name);
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Se come a"+animal);
    }

    @Override
    public void comerCarne() {
        System.out.println("Se come un pedazo de carne");
    }
}
