public class Persona {
    //Atributos
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;
    //Constructores
    public Persona(){};

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

    //Metodos
    public int calcularIMC(){
        if(this.peso==0||this.altura==0){
            System.out.println("Sin necesarios, inserte los datos para calcular el IMC");
        }
        double imc = this.peso/Math.pow(this.altura,2);
        if(imc<20){return -1;}
        else if(imc>=20&&imc<=25){return 0;}
        else{ return 1;}

    }
    public boolean esMayorDeEdad(){
        if(edad<=0){return false;}
        else {return true;}
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
    //Metodos Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }



}
