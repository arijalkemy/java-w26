package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Informe informe = new Informe("Este es el texto del informe",1,"Juan Cruz Caserio","Meli");
        informe.imprimir();

        LibroPDF libroPDF = new LibroPDF(1,"Juan Cruz Caserio","Interfaces y Clases Abstractar", "Terror");
        libroPDF.imprimir();

        Persona persona = new Persona("Jose",25,"34567123","Caseros 3812");
        persona.agregarHabilidad("Ingles");
        persona.agregarHabilidad("Python");

        Curriculum curriculum = new Curriculum(persona);
        curriculum.imprimir();

    }
}
