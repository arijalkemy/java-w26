package org.ggomezr;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private String peso;
    private String altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, String peso, String altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double pesoEnKilos = Double.parseDouble(this.peso);
        double alturaEnMetros = Double.parseDouble(this.altura);

        int indicadorImc = 0;

        try{
            if(alturaEnMetros == 0 || pesoEnKilos == 0) throw new IllegalArgumentException("El valor de la altura y del peso no puede ser cero");
            double imc = pesoEnKilos / Math.pow(alturaEnMetros, 2);
            if(imc < 20) indicadorImc = -1;
            else if(imc >= 20 && imc <= 25) indicadorImc = 0;
            else indicadorImc = 1;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        return indicadorImc;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso='" + peso + '\'' +
                ", altura='" + altura + '\'' +
                '}';
    }
}
