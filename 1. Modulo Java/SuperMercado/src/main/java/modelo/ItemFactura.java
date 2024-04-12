package modelo;

public class ItemFactura {
    public String codigo;
    public Producto producto;
    public int cantidadComprada;
    public int costoUnitario;

    public ItemFactura(String codigo, Producto producto, int cantidadComprada, int costoUnitario) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public int getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
