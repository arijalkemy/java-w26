package ejercicio3;

public interface Comida<T> {

    static <T> void comerAnimal(T animal){
        if(animal instanceof Gato || animal instanceof Perro){
            System.out.println("Comiendo carne");
        }else {
            System.out.println("Comiendo hierba");
        }
    }
}
