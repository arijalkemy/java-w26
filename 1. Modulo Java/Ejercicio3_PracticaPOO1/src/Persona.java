public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){
        this.nombre = "Miguel";
        this.edad = 18;
        this.dni = "10224";
        this.peso = 100;
        this.altura = 186;
    }
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni,double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso / Math.pow(this.altura,2);
        if(imc < 20.0){
            return (-1);
        }else {
            if (imc > 20 && imc < 25){
                return 0;
            }
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if (this.edad > 18){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String datosCompletos = "Nombre: "+this.nombre+" \r\n"+
                "Edad: "+this.edad+" \r\n"+
                "DNI: "+this.dni+" \r\n"+
                "Peso: "+this.peso+" \r\n"+
                "Altura: "+this.altura+" \r\n";
        return datosCompletos;
    }
}
