public class Participante {
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String emergencia;
    private String grupoSanguineo;

    // Constructor
    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String emergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.emergencia = emergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    // Getters
    public int getNumero() {
        return numero;
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

    public String getCelular() {
        return celular;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
