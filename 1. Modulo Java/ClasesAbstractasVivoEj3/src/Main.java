public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        comerAnimal(perro);

        gato.emitirSonido();
        comerAnimal(gato);

        vaca.emitirSonido();
        comerAnimal(vaca);
    }

    /*En los metodos de comerAnimal puede pasar que le pases un animal
    * que no implemente alguna de esas dos interfaces y pueda romper el codigo.
    * Faltaria cubrir ese caso o repensar el diseño.
    * */

    private static void comerAnimal(IHerviboro animal){
        animal.comerHierba();
    }

    private static void comerAnimal(ICarnivoro animal){
        animal.comerCarne();
    }
}
