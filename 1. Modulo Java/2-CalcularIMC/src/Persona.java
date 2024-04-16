public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public static Persona CrearPersonaSinDni(String nombre, int edad){
        return new Persona(nombre, edad, "");
    }

    public int  calcularIMC(){
        if(this.altura == 0){
            return -1;
        }
        double imc = (this.peso / (this.altura * this.altura));
        if(imc < 20) return -1;
        else if(imc <= 25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad(){
        return (18 <= this.edad);
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                " Edad: " + this.edad +
                " DNI: " + this.dni +
                " Peso: " + this.peso +
                " Altura: " + this.altura;
    }
}
