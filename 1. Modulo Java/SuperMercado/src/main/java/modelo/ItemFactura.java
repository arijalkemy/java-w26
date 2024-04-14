package modelo;

public class ItemFactura {

    private static int id;
    public int codigo;
    public Producto producto;
    public int cantidadComprada;
    public double costoUnitario;

    public ItemFactura(Producto producto, int cantidadComprada, double costoUnitario) {
        this.codigo = ++id;
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "codigo=" + codigo +
                ", producto=" + producto +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
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


    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
