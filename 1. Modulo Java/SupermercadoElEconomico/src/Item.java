public class Item {
    private int codigoItem;
    private String nombreItem;
    private int cantidadItems;
    private double costoUnitarioItem;

    public Item(int codigoItem, String nombreItem, int cantidadItems, double costoUnitarioItem) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.cantidadItems = cantidadItems;
        this.costoUnitarioItem = costoUnitarioItem;
    }

    public double getTotal(){
        return costoUnitarioItem * cantidadItems;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }

    public double getCostoUnitarioItem() {
        return costoUnitarioItem;
    }

    public void setCostoUnitarioItem(double costoUnitarioItem) {
        this.costoUnitarioItem = costoUnitarioItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigoItem=" + codigoItem +
                ", nombreItem='" + nombreItem + '\'' +
                ", cantidadItems=" + cantidadItems +
                ", costoUnitarioItem=" + costoUnitarioItem +
                '}';
    }
}
