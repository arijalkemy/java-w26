import java.util.List;
//Clase implementadora de la interface
public class Curriculum implements Impresora{
    //Atributos
    private String nombre;
    private String telefono;
    private String email;
    private List<String> habilidades;
    //Constructor
    public Curriculum(String nombre, String telefono, String email, List<String> habilidades){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.habilidades = habilidades;
    }
    //implementación de la firma del metodo definido desde la interface
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libro...");
        System.out.println("Nombre aspirante: "+this.nombre+"\r\n"+"Telefono: "+this.telefono+"\r\n"
                +"email: "+this.email+"\r\n"+"habilidades: "+this.habilidades+"\r\n");
    }
}
