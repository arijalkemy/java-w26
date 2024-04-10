package bootcamp.bendezujonathan;

public class NoPerecedero extends Producto {

    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" Tipo: %s", this.tipo);
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    


}
