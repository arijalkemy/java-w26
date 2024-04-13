public class Main {
    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaSinPesoNiAltura = new Persona("persona1", 40, "25000223");
        Persona personaTodosLosPatametros = new Persona(
                "personaFull",
                20,
                "33223322",
                70,
                1.75);

        // Crear esta persona no es posible Java lanza un error en tiempo de compilación debido a que no existe un constructor para dichos parametros
        //    Persona personaParametrosIncorrectos = new Persona("personaNoSoportada", 50);

        System.out.println(personaTodosLosPatametros.toString());
    }
}