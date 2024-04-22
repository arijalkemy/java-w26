package person;

public class Main {
    public static void main(String[] args) {
        Person personEmpty = new Person();
        Person personWithoutAgeAndHeight = new Person("Blas", 24, "42512901");
        Person person = new Person("Blas", 15, "44333222", 130, 1.9);

        // Print age
        if (person.isOfLegalAge()) {
            System.out.println(person.name + " es mayor de edad.");
        } else {
            System.out.println(person.name + " es menor de edad.");
        }

        // Print IMC
        System.out.println("Su IMC es de " + person.calculateImc());

        // Print description
        String imcInfoText = "";
        int imcInfo = person.computeImcInfo();
        if (imcInfo == -1) {
            imcInfoText = "bajo peso";
        } else if (imcInfo == 0) {
            imcInfoText = "peso saludable";
        } else {
            imcInfoText = "sobrepeso";
        }
        System.out.println("La persona " + person.name + " de DNI " + person.dni + " tiene " + person.age + " años, pesa " + person.weight + "kg y mide " + person.height + " metros. Según su IMC esta persona tiene " + imcInfoText + ".");

        // Print object
        System.out.println(person);
    }
}
