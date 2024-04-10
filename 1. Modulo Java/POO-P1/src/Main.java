public class Main {
    public static void main(String[] args) {

        //Se instancian personas con distintos tipos de constructores
        Persona personaSinConstructor = new Persona();
        Persona personaConTresParametros = new Persona("Franco", 25, "99999999");
        Persona personaCompleta = new Persona("Franco", 25, "99999999", 10.0, 100.0);

        //No se puede construir la persona a continuacion ya que no se creo un constructor que acepte esos parametros en la clase persona
        //Persona personaConDosParametros = new Persona("Franco", 25);
    }
}