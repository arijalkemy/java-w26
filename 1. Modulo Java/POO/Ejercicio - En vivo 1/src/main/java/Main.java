public class Main {
    public static void main( String[] args ) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro",24,"FGHJI283");
        Persona persona3 = new Persona("Ana",27,"6GGT36J",52.7,1.50);
        persona3.calcularIMC(52.7, 1.50);
        System.out.printf(persona2.toString());
    }

}
