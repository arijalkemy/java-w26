public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Integer minimaEdadRequerida = null;

    public void setMinimaEdadRequerida(Integer minimaEdadRequerida) {
        this.minimaEdadRequerida = minimaEdadRequerida;
    }

    public Integer getMinimaEdadRequerida() {
        return minimaEdadRequerida;
    }

    public Categoria(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
