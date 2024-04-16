package person;

public class Person {
    String name;
    int age;
    String dni;
    double weight;
    double height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public double calculateImc() {
        double imc = 0;
        try {
            if (this.height == 0) {
                throw new Exception("No se puede dividir por cero.");
            }
             imc = this.weight / Math.pow(this.height, 2);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return imc;
    }

    public int computeImcInfo() {
        double imc = this.calculateImc();
        if (imc < 20) {
            return -1;
        } else if (imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isOfLegalAge() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name = '" + name +
                ", age = " + age +
                ", dni = '" + dni +
                ", weight = " + weight +
                ", height = " + height +
                " }";
    }
}
