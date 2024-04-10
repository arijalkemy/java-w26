class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private int precioMayor;
    private int precioMenor;

    public Categoria(String id, String nombre, String descripcion, int precioMayor, int precioMenor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMayor = precioMayor;
        this.precioMenor = precioMenor;
    }

    public int valor(int edad){
        return edad >= 18 ? precioMayor : precioMenor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}