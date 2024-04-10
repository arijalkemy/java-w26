public class Person {
    private String name;
    private Integer age;
    private String dni;
    private Double heigth;
    private Double weigth;

    public Person() {
    }

    public Person(String name, Integer age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, Integer age, String dni, Double heigth, Double weigth) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.heigth = heigth;
        this.weigth = weigth;
    }

    public int calcularIMC() {
        try {
            if (heigth == null || heigth == 0) {
                throw new ArithmeticException("Invalid heigth");
            }
            double calc = this.weigth / (this.heigth * this.heigth);
            if (calc < 20) {
                return -1;
            }
            if (calc < 25) {
                return 0;
            }
            return 1;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("[PERSON] Nombre: %s Dni: %s Edad: %d Peso: %.2f Altura: %.2f", name, dni, age, weigth, heigth);
    }
}
