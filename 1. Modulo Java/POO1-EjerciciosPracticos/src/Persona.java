public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    // Se crea un constructor solo con los parametros necesarios para poder pasar solo esos parametros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso / Math.pow(this.altura, 2);

        if (imc < 20){
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        }

        return 1;
    }

    public boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        if (this.nombre == null){
            return "Esta persona no tiene informacion";
        }

        if (this.peso != 0 && this.altura != 0){
            return "Nombre: " + this.nombre + "" +
                "\nEdad: "+ this.edad +
                "\nDNI: " + this.dni +
                "\nAltura: " + this.altura +
                "\nPeso: " + this.peso +
                "\nIMC: " + this.calcularIMC() +
                "\nMayor de Edad: " + this.esMayorDeEdad();
        }else {
            return "Nombre: " + this.nombre + "" +
                    "\nEdad: "+ this.edad +
                    "\nDNI: " + this.dni;
        }


    }
}
