import java.security.cert.CertificateRevokedException;

public class Participante {
    private int no_participante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long celular;
    private long celular_emergencia;
    private String grupo_sengre;

    private Categoria inscripcion;

    public Participante(int no_participante, String dni, String nombre, String apellido, int edad, long celular, long celular_emergencia, String grupo_sengre) {
        this.no_participante = no_participante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celular_emergencia = celular_emergencia;
        this.grupo_sengre = grupo_sengre;
    }

    public void setInscripcion(Categoria inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getNo_participante() {
        return no_participante;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public long getCelular() {
        return celular;
    }

    public long getCelular_emergencia() {
        return celular_emergencia;
    }

    public String getGrupo_sengre() {
        return grupo_sengre;
    }

    public Categoria getInscripcion() {
        return inscripcion;
    }

    public double getMontoInscrito(){

        if (this.edad < 18 ){
            return this.inscripcion.getMontoMenores();
        }
        return this.inscripcion.getMontoMayores();
    }
}
