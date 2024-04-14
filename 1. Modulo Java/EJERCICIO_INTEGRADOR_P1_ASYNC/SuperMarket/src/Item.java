public class Item {
    private String codigo, nombre;
    private int cantidad_comprada;
    private float costo_unitario;


    public Item(String codigo, String nombre, int cantidad_comprada, float costo_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad_comprada = cantidad_comprada;
        this.costo_unitario = costo_unitario;
    }


    @Override
    public String toString() {
        return "Item [codigo=" + codigo + ", nombre=" + nombre + ", cantidad_comprada=" + cantidad_comprada
                + ", costo_unitario=" + costo_unitario + "]";
    }

    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCantidad_comprada() {
        return cantidad_comprada;
    }


    public void setCantidad_comprada(int cantidad_comprada) {
        this.cantidad_comprada = cantidad_comprada;
    }


    public float getCosto_unitario() {
        return costo_unitario;
    }


    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    


}
