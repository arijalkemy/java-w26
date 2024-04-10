public class Main {
    public static void main(String[] args) {

        // Se crea un objeto por cada tipo de constructor
        Person personWithouthParams = new Person();
        Person personNameAgeDni = new Person("Juan", 22, "43334122");
        Person personFullConstructor = new Person("Pepe", 6, "34333232", 232.2, 1.33);

        // Calculo IMC
        personFullConstructor.calculateIMC();

        System.out.println(personFullConstructor);
    }



}
