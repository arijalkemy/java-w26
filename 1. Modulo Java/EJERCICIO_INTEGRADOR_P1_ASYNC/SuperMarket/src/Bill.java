import java.util.List;

public class Bill {
    private Customer custormer;
    private List<Item> items;
    private float totalPurchase;


    public Bill(Customer custormer, List<Item> items, float totalPurchase) {
        this.custormer = custormer;
        this.items = items;
        this.totalPurchase = totalPurchase;
    }


    public Customer getCustormer() {
        return custormer;
    }


    public void setCustormer(Customer custormer) {
        this.custormer = custormer;
    }


    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }


    public float getTotalPurchase() {
        return totalPurchase;
    }


    public void setTotalPurchase(float totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    

}
