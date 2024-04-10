package bootcamp.bendezujonathan;

import java.util.Map;

import bootcamp.bendezujonathan.calculator.Persona;

public class Main 
{

    private static final Map<Integer, String> imcStatus = Map.of(-1, "Bajo peso!!", 
                                                                0, "Peso saludable :)",
                                                                1, "Sobrepeso");

    
    public static void main( String[] args )
    {
        // Persona noData = new Persona();
        // Persona leo = new Persona("Leo", 23, "12334");
        Persona allData = new Persona("Leonel", 23, "1234", 75, 1.75);
        String imcStatusLeo = imcStatus.getOrDefault(allData.calcularIMC(), "No pudo calcularse el IMC");
        String mayoriaDeEdad = (allData.esMayorDeEdad()) ? "Mayor" : "Menor";
        System.out.println("--------- Paciente Info ---------");
        System.out.println(allData);
        System.out.println(String.format(">> Paciente %s de edad.", mayoriaDeEdad));
        System.out.println(">> IMC Estado: " + imcStatusLeo);
    }
}
