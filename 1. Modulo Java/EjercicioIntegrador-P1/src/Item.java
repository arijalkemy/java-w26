public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(String codigo, String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }
}
