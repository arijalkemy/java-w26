
//EJERCICIO 1
public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //EJERCICIO 2
    public Persona(){

    }

    public Persona(String nombre,int edad,String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre,int edad,String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    //EJERCICIO 5
    public int calcularIMC(){
        double resultado = this.peso/(Math.pow(this.altura,2));

        if(resultado<20) return -1;

        if(20<=resultado && resultado<=25) return 0;

        //Si es mayor de 25 retorna 1
        return 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    public String toString(){

        return "Nombre: "+ nombre + "\nEdad: "+edad + "\nDni: "+ dni + "\nPeso: " +peso+ " kg."+"\nAltura: "+altura+" mts.";
    }




}
