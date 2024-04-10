public class Main {
    public static void main( String[] args )
    {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Franco", 21, "44195956");
        Persona persona3 = new Persona("Franco", 21, "44195956",78.9,1.74);

        switch (persona3.calcularIMC()) {
            case -1:
                System.out.println("Tiene bajo peso");
                break;
            case 0:
                System.out.println("Tiene peso saludable");
                break;
            case 1:
                System.out.println("Tiene sobrepeso");
                break;
            default:
                System.out.println("Valor de IMC incorrecto");
        }
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");
        System.out.println(persona3.toString());
    }
}