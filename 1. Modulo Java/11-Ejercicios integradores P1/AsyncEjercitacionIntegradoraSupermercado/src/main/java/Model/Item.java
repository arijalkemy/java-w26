package Model;

public class Item {
    private String itemCode;
    private String name;
    private int cant;
    private double priceByUnit;

    public Item(String itemCode, String name, int cant, double priceByUnit) {
        this.itemCode = itemCode;
        this.name = name;
        this.cant = cant;
        this.priceByUnit = priceByUnit;
    }

    public Item() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPriceByUnit() {
        return priceByUnit;
    }

    public void setPriceByUnit(double priceByUnit) {
        this.priceByUnit = priceByUnit;
    }
}
