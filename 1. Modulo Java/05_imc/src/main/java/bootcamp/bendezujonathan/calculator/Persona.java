package bootcamp.bendezujonathan.calculator;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }


    public int calcularIMC() {
        int result = Integer.MAX_VALUE;
        try {
            double imc = (peso / (Math.pow(altura, 2)));
            
            result = (imc < 20) ? -1 : (imc > 25) ? 1 : 0; 

        } catch (ArithmeticException e) {
            System.out.println("[ERROR] No se puede dividir por cero, la altura probablemente es 0");
        }
        return result;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString(){
        return String.format(">> Nombre: %s Dni: %s Edad: %d \n>> Peso: %.2f Altura: %.2f" , nombre, dni, edad, peso, altura);
    }
}
