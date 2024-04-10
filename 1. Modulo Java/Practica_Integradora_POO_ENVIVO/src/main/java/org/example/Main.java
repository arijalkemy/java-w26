package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creación de una persona con el contructor vacio
        Person personUno = new Person();
        System.out.println(personUno.toString());
        //Creación de una persona con el contructor que tiene nombre, edad y dni
        Person personDos = new Person("Diana", 25, "1239871321A");
        System.out.println(personDos.toString());
        //Creación de una persona con el contructor que tiene nombre, edad, dni, peso y altura
        Person personTres = new Person("Diego",15, "1298218281V", 56.0, 1.90);
        System.out.println(personTres.toString());

        //Creación de una persona sin un contructor que tiene nombre y edad
        //Person personCuatro = new ("Ramiro",19);
        //Aparecerá un error "Identifier" ya que no se ha creado un constructor que solo admita únicamente estos dos parametros

        //Calcular IMC
        double imcPersonaTres = personTres.calcularIMC();
        String respuestaIMC;
        switch ((int)imcPersonaTres){
            case -1:
                respuestaIMC="peso bajo";
            break;
            case 0:
                respuestaIMC="peso saludable";
            break;
            case 1:
                respuestaIMC="peso sobrepeso";
            break;
            default:
                respuestaIMC="no hay información";
            break;
        }
        System.out.println("El IMC de : "+ personTres.getNombre()+" establece que tiene: " + respuestaIMC);

        //Mayoría de edad
        boolean mayorDeEdad = personTres.esMayorDeEdad();
        String respuestaEdad = mayorDeEdad ? "Es mayor de edad" : "No es mayor de edad";
        System.out.println(personTres.getNombre()+ " " + respuestaEdad);

        //Mostrar todos los datos
        System.out.println("Datos completos de la persona: ");
        System.out.println(personTres);
    }
}