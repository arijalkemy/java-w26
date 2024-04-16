import java.lang.Math;
public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;
    public Persona(){

    }
    public Persona(String nombre,int edad, String dni){
        nombre = this.nombre;
        edad = this.edad;
        dni = this.dni;
    }
    public Persona(String nombre,int edad, String dni,double peso,double altura){
        nombre = this.nombre;
        edad = this.edad;
        dni = this.dni;
        peso = this.peso;
        altura = this.altura;
    }
    public int calcularIMC(){
        double IMC = 0;
        IMC =  this.peso/(Math.pow(this.altura, 2));
        if(IMC < 20){
            System.out.println("Bajo Peso");
            return -1;
        }
        else if(IMC>=20 && IMC <=25){
            System.out.println("Peso saludable");
            return 0;
        }
        else {
            System.out.println("Sobrepeso");
            return 1;
        }
    }
    public boolean MayorDeEdad(){
        if(edad >= 18){
            System.out.println("El paciente es mayor de edad");
            return true;
        }
        else {
            System.out.println("El paciente es menor de edad");
            return false;
        }
    }
    @Override
    public String toString(){
        return "Nombre: "+nombre+" edad: "+edad+" dni: "+dni+" peso: "+peso+" altura: "+altura;
    }
}
