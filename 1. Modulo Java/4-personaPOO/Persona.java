public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;
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

    public int calcularIMC(){
        double valueAux = this.peso / (this.altura * this.altura);
        if (valueAux < 20){
            return -1;
        }
        else if (valueAux >= 20 && valueAux <= 25){
            return 0;
        }
        else{
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        if (this.edad < 18){
            return false;
        }
        return true;
    }
    public String toString(){
        return "Nombre: " + this.nombre + " Edad: " + this.edad + " Dni: " + this.dni + " Peso: " + this.peso + " Altura: " + this.altura;
    }
}
