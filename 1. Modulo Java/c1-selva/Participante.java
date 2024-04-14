public class Participante{
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String emergencia;
    private String sangre;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String emergencia, String sangre){
        this.numero=numero;
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.celular=celular;
        this.emergencia=emergencia;
        this.sangre=sangre;
    }

    public void mostrarParticipante(){
        System.out.println("Nombre:"+nombre+" Edad:"+edad);
    }
    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }
}