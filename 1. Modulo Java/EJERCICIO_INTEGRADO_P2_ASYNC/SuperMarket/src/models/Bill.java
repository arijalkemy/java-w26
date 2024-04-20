package models;
import java.util.List;

public class Bill {
    private Customer custormer;
    private List<Product> items;
    private float totalPurchase;
    private int idBill;

    private static int id = 0;

    public Bill(int idBill, Customer custormer, List<Product> items) {
        this.idBill = idBill;
        this.custormer = custormer;
        this.items = items;
        this.totalPurchase = 0;
    }

    public static int getId(){
        int actualId = id;
        id++;
        return actualId;
    }

    public void calculateTotalPurchase()
    {
        for (Product item : items) {
            totalPurchase += item.getUnitCost(); 
        }
    }

    public Customer getCustormer() {
        return custormer;
    }


    public void setCustormer(Customer custormer) {
        this.custormer = custormer;
    }


    public List<Product> getItems() {
        return items;
    }


    public void setItems(List<Product> items) {
        this.items = items;
    }


    public float getTotalPurchase() {
        return totalPurchase;
    }


    public void setTotalPurchase(float totalPurchase) {
        this.totalPurchase = totalPurchase;
    }



    public int getIdBill() {
        return idBill;
    }



    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    @Override
    public String toString() {
        return "Bill for custormer: " + custormer + "\nItems:\n" + items + "\n TotalPurchase: " + totalPurchase + ", idBill="
                + idBill + "]";
    }

    

}
