public class Main {
    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else{
            ((Herviboro) animal).comerHierba();
        }
    }
    public static void main(String[] args){
        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        gato.emitirSonido();
        comerAnimal(gato);

        perro.emitirSonido();
        comerAnimal(perro);

        vaca.emitirSonido();
        comerAnimal(vaca);
    }
}
