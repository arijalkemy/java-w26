package models;

public abstract class ElementMarket {
    private String id;
    private String name;
    private float unitCost;

    public ElementMarket(String id, String name, float unitCost) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    
}
