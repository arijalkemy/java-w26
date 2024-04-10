//Ejercicio 1 - Crear clase persona
public class Persona{
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

//Ejercicio 2 - Constructores
    public Persona() {
    }
    public Persona(String nombre, int edad, String dni){
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

// Metodos
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    // Ejercicio 5 - Calcular IMC, Mayor de edad y toString.
    public int calcularIMC(){
        double imc = this.peso / (Math.pow(this.altura,2));
        return (imc<20)?-1 : (imc>25)?1 :0;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return  "Nombre: '" + nombre + '\'' +
                ", Edad: " + edad +
                ", DNI: '" + dni + '\'' +
                ", Peso: " + peso +
                ", Altura: " + altura;
    }
}


