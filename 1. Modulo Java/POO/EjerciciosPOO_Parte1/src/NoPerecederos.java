public class NoPerecederos extends Productos{
    private String tipo;

    public NoPerecederos(String nombre, double precio,String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString()+" tipo "+this.tipo;
    }
}
