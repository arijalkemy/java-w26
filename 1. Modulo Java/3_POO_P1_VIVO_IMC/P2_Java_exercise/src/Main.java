public class Main {


    public static void main(String [] args){
        Persona persona_Uno = new Persona();
        Persona persona_Dos = new Persona("Radamel",35,"100089699");
        Persona persona_Tres = new Persona("Frank", 15, "100213288",80.6,1.7);
        Persona persona_Cuatro = new Persona("Brandon", 30, "77123771",71.5,1.81);

        Persona clienteAExaminar = persona_Cuatro;

        System.out.println(clienteAExaminar.toString());
        if(clienteAExaminar.esMayordeEdad()){
            System.out.print("Eres mayor de edad");
        }else{
            System.out.print("Eres menor de edad");
        }
        System.out.println(" Y tu indice de masa corporal es: "+ clienteAExaminar.calcularIMC());

        System.out.println("La interpretacion del resultado es la siguiente: ");
        int IMCCliente = clienteAExaminar.calcularIMC();
        if(IMCCliente == -1){
            System.out.println("tienes un IMC menor a 20, por lo tanto estas en bajo peso");
        }else if (IMCCliente== 0) {
            System.out.println("Tienes un IMC entre 20 y 25, por lo cual eres considerado saludable");
        }else if (IMCCliente == 1){
            System.out.println("Tienes un IMC mayor a 25, tienes sobrepeso");
        }


    }
}
