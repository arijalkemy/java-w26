public class Main {
    public static void main(String[] args) {

        //Se instancian personas con distintos tipos de constructores
        Persona personaSinConstructor = new Persona();
        Persona personaConTresParametros = new Persona("Franco", 25, "99999999");
        Persona personaCompleta = new Persona("Franco", 25, "99999999", 30.0, 1.0);

        //No se puede construir la persona a continuacion ya que no se creo un constructor que acepte esos parametros en la clase persona
        //Persona personaConDosParametros = new Persona("Franco", 25);

        //Se muestra en consola los datos del calculo de IMC, si es mayor de edad y toda la informacion del usuario
        System.out.println("Calculo de IMC: " + personaCompleta.nivelDePeso());

        //Calculo mensaje a mostrar segun si es mayor o menor de edad
        String mensajeEdad = personaCompleta.esMayorDeEdad() ? "La persona es MAYOR de edad" : "La persona es MENOR de edad";
        System.out.println(mensajeEdad);

        System.out.println("Datos de la persona: " + personaCompleta.toString());
    }
}