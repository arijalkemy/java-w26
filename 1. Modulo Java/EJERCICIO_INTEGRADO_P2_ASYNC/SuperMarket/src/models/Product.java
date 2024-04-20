package models;

public class Product extends ElementMarket {
    private int stock;


    public Product(String id, String name, float unitCost, int stock) {
        super(id, name, unitCost);
        this.stock = stock;
    }

    public static Product of(int stock, String id, String name, float unitCost) 
    {
        return new Product(id, name, unitCost, stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Nombre: "+getName() + " Costo: " + getUnitCost() + ".";
    }

    
}
