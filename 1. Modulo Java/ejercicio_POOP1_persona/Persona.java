public class Persona {
    private String nombre;
    private int edad;
    private String id;
    private double peso;
    private double altura;
    public Persona(){

    }

    public Persona(String nombre, int edad, String id){
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public Persona(String nombre, int edad, String id, double peso, double altura){
        this.nombre =  nombre;
        this.edad = edad;
        this.id = id;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double aux = this.peso/(this.altura * this.altura);
        if (aux >= 20 && aux <= 25){
            return 0;
        } else if (aux > 25) {
            return 1;
        }else{
            return -1;
        }
    }
    public boolean esMayorDeEdad(){
        if (edad > 18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", id='" + id + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
