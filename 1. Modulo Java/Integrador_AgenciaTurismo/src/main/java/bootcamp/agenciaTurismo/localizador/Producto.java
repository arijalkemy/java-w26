package bootcamp.agenciaTurismo.localizador;

public class Producto {
    
    private double costoUnitario;
    private TiposProducto tipo;

    public Producto(double costoUnitario, TiposProducto tipo) {
        this.costoUnitario = costoUnitario;
        this.tipo = tipo;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public TiposProducto getTipo() {
        return tipo;
    }

    public void setTipo(TiposProducto tipo) {
        this.tipo = tipo;
    }

}
