package Persona;

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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc =  this.peso/(Math.pow(this.altura,2));

        if(imc<20){
            return -1;
        }
        else if(imc>25){
            return 1;
        } else {
            return 0;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    @Override
    public String toString() {
        String mayoriaDeEdad = this.esMayorDeEdad() ? "mayor" : "menor";
        return "Persona: \n" +
                "\t Nombre: " + nombre + '\n' +
                "\t Edad:  " + edad + '\n' +
                "\t DNI:   " + dni + '\n' +
                "\t Peso:  " + peso + '\n' +
                "\t Altura: " + altura + '\n' +
                "\t La persona posee un " + this.formatIMC() + '\n' +
                "\t Es " + mayoriaDeEdad + " de edad";
    }

    private String formatIMC(){
        if(this.calcularIMC() == -1) {
            return "BAJO PESO";
        } else if (this.calcularIMC() == 0){
            return "PESO SALUDABLE";
        } else {
            return "SOBREPESO";
        }

    }
}
