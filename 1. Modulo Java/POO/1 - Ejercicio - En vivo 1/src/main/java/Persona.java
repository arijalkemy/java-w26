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
    public int calcularIMC(double peso, double altura){
        double IMC = 0;
        IMC =  this.peso/(Math.pow(this.altura, 2));
        if(IMC < 20){
            return -1;
        }
        else if(IMC>=20 && IMC <=25){
            return 0;
        }
        else {
            return 1;
        }
    }
    public boolean MayorDeEdad(){
        if(edad >= 18){
            return true;
        }
        else {
            return false;
        }
    }
    public void toStringPersona(){
        System.out.println(nombre+" "+edad+" "+dni+" "+peso+" "+altura);
    }
}
