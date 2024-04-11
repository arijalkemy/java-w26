public class App {
    public static void main(String[] args) throws Exception {
        Animal animal_perro = new Perro("Perro", "Banano");
        animal_perro.hacerSonido();
        animal_perro.mostrarEspecie();
        
        Animal animal_gato = new Gato("Gato", "Gris");
        animal_gato.hacerSonido();
        animal_gato.mostrarEspecie();
    }
}
