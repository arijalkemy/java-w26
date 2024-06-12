public class Persona {
    int edad;
    String nombre;
    String dni;
    double estatura;
    double peso;

    public Persona() {
    }

    public Persona(int edad, String nombre, String dni) {
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(int edad, String nombre, String dni, double estatura, double peso) {
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
        this.estatura = estatura;
        this.peso = peso;
    }

    public int calcularIMC() {
        try{
            double imc = (peso) / Math.pow(estatura, 2);
            System.out.println(imc);
            if (imc < 20) {
                return -1;
            } else if (imc <= 25) {
                return 0;
            } else {
                return 1;
            }

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        return -2;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format(">> Nombre: %s Dni: %s Edad: %d \n>> Peso: %.2f Estatura: %.2f" , nombre, dni, edad, peso, estatura);
    }

}
