public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Mara", "Gonzalez");
        persona.agregarHabilidad("Ingles", "JavaScript", "Java");

        Documento documento1 = new Curriculum(persona);
        Documento documento2 = new LibroPDF(124,"Stephen King","It","Terror");
        Documento documento3 = new Informe("Breve texto",123,"Maria Rodriguez", "Pablo Lopez");

        Imprimible.imprimirDocumento(documento1);
        Imprimible.imprimirDocumento(documento2);
        Imprimible.imprimirDocumento(documento3);

    }
}
