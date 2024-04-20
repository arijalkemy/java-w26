package models;
public class Item extends ElementMarket {
    private int count;

    public Item(String id, String name, float unitCost, int count) {
        super(id, name, unitCost);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
