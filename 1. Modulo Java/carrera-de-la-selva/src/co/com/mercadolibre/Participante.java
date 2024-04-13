package co.com.mercadolibre;

class Participante {
    private int numeroInscripcion;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private Categoria categoria;

    public Participante(int numeroInscripcion, String dni, String nombre, String apellido,
                        int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroInscripcion = numeroInscripcion;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public double calcularMontoInscripcion(Categoria categoria) {
        double montoBase;

        if ("Circuito chico".equals(categoria.getNombre())) {
            montoBase = (edad < 18) ? 1300 : 1500;
        } else if ("Circuito medio".equals(categoria.getNombre())) {
            montoBase = (edad < 18) ? 2000 : 2300;
        } else if ("Circuito avanzado".equals(categoria.getNombre())) {
            montoBase = 2800;
        } else {
            montoBase = 0;
        }

        return montoBase;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}