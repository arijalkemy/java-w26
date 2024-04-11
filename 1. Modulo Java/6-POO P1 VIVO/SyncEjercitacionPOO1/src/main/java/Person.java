public class Person {

    String name;
    int age;
    String dni;
    double weight;
    double height;


    public Person() {
        this.name = "";
        this.age = 0;
        this.dni = "";
        this.weight = 0.0;
        this.height = 0.0;
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = 0.0;
        this.height = 0.0;
    }


    public Person(String name, int age, String dni, double peso, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = peso;
        this.height = height;
    }

    public int calculateIMC() {
        double imc = weight / Math.pow(height, 2);

        if (imc < 20) {
            return -1;

        } else if (imc >= 20 && imc <= 25) {
            return 0;

        } else {
            return 1;
        }
    }

    public boolean isOfLegalAge() {
        return age > 18;
    }


    public static String weightManagment(int imc) {
        return switch (imc) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso saludable";
            case 1 -> "Sobrepeso";
            default -> throw new RuntimeException("Unexpected value: " + imc);
        };
    }

    public String toString() {
        String statusAge = isOfLegalAge() ? "Es mayor de edad" : "No es mayor de edad";
        String statusWeight = weightManagment(calculateIMC());

        return "Persona{" +
                "nombre ='" + name + '\'' +
                ", edad =" + age +
                ", dni ='" + dni + '\'' +
                ", peso = " + weight +
                ", altura = " + height +
                ",rango etario ='" + statusAge + '\'' +
                ", estadoPeso='" + statusWeight + '\'' +
                '}';
    }
}

