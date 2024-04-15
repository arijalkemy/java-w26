package punto3;
public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.sonido();
        ((Carnivoro) perro).comerCarne();

        Animal gato = new Gato();
        gato.sonido();
        ((Carnivoro) gato).comerCarne();

        Animal vaca = new Vaca();
        vaca.sonido();
        ((Herviboro) vaca).comerHierba();
    }
    public static void comerAnimal(Animal animal) {
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else if(animal instanceof Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }
}