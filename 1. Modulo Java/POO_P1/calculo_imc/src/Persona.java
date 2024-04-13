public class Persona implements CalcularIMC {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    @Override
    public int calcularIMC(double peso, double altura) throws ArithmeticException {
        double indice = peso / Math.pow(altura, 2.0);
        if (altura == 0 || indice <= 0) throw new ArithmeticException("el peso y/0 la edad es/son incorrectos");
        if (indice < 20) {
            return -1;
        } else if (20 <= indice && indice <= 25) {
            return 0;
        }
        return 1;
    }

    private boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private String estadoDePesoSegunIMC() {
        try {
            int indice = calcularIMC(peso, altura);
            return switch (indice) {
                case -1 -> "bajo peso";
                case 0 -> "peso saludable";
                default -> "sobrepeso";
            };
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return "desconocido";
    }

    @Override
    public String toString() {
        String mayoriaDeEdad = this.esMayorDeEdad() ? "mayor" : "menor";
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", la persona posee un " + this.estadoDePesoSegunIMC() +
                ", la persona es " + mayoriaDeEdad + " de edad" +
                '}';
    }
}
