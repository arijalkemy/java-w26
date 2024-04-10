package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person emptyPerson = new Person();
        Person basicPerson = new Person("Juan", 24, "122232");
        Person completePerson = new Person("Carlos", 12, "12312", 74, 1.82f);
        // Person basicPerson = new Person("Juan", 24); Esto no es posible pues no hay constructor para este caso

        System.out.println("Datos del usuario:");
        System.out.println(completePerson.toString());
        System.out.println("IMC del usuario:");
        System.out.println(getIMCMsg(completePerson.calcularIMC()));
        System.out.println("Es mayor de edad:");
        System.out.println(completePerson.esMayorDeEdad() ? "Si" : "No");
    }

    public static String getIMCMsg(short imc) {
        if (imc == -1) return "Bajo peso";
        if (imc == 0) return "Peso saludable";
        return "Sobrepeso";
    }
}
