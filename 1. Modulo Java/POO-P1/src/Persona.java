public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
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

    private int cacularIMC(){
        double imc = peso/(Math.pow(altura, 2));
        return imc < 20 ? -1 : (imc >= 20 && imc <= 25) ? 0 : 1;
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public String nivelDePeso(){
        int calculoImc = cacularIMC();
        return calculoImc == -1 ? "Bajo peso" : calculoImc == 0 ? "Peso saludable" : "Sobrepeso";
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
