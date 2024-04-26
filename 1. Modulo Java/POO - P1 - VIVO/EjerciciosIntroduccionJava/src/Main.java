public class Main {
    public static void main(String[] args) {
        Persona persona1= new Persona();
        Persona persona2= new Persona("Santiago",25,"123");
        Persona persona3= new Persona("Santiago",25,"123",70, 1.7F);
        Persona persona4= new Persona("Santiago",25,"",0,0);

        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad()?"Es mayor de edad":"No es mayor de edad");
        System.out.println(persona3.toString());
    }
}