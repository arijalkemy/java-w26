//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se crean los distintos tipos de personas como se solicita
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos",26,"236458");
        Persona persona3 = new Persona("Andrea",22,"5550123",45.2,1.55);

        //Persona persona4 = new Persona("Carlos",26);

        //Permite calcular el indice de masa corporal y muestra el resultado
        int imc = persona3.calcularIMC();
        if(imc == -1){
            System.out.println("Estás en un bajo peso");
        }else {
            if (imc == 0){
                System.out.println("Estás en un buen peso");
            }else {
                System.out.println("Estás en sobrepeso");
            }
        }

        //Permite calcular si la persona es mayor de edad e imprime el resultado
        boolean isMayorEdad = persona3.esMayorDeEdad();
        if(isMayorEdad){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("No eres mayor de edad");
        }

        //Muestra la informacion general de la persona
        System.out.println("la información completa de este usuario es:");
        System.out.println(persona3.toString());

    }
}