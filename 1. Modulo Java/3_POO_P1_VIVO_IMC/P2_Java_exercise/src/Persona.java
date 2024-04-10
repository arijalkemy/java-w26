public class Persona {
    public String nombre;
    public int edad;
    public String DNI;;
    public double peso;
    public double altura;

    public Persona(){

    }
    public Persona(String nombre, int edad, String Dni){
        this.nombre = nombre;
        this.edad  = edad;
        this.DNI = Dni;
    }
    public Persona(String nombre, int edad, String Dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = Dni;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        double resultadoIMC = this.peso/(this.altura*this.altura);
        int valorRespuesta = 2;
    if (resultadoIMC < 20.0){
        valorRespuesta= -1;
    }else if(resultadoIMC >= 20.0 && resultadoIMC <= 25.0){
        valorRespuesta =  0;
    }else if (resultadoIMC > 25.0)
        valorRespuesta = 1;
    return valorRespuesta;
    }
    public boolean esMayordeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Hola " + this.nombre + "! tienes "+this.edad+ " pesas "+ this.peso+" kg y mides "+this.altura+" metros";
    }
}
