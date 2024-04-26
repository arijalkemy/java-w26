package Model;

import java.util.List;

public class Ticket {
    private Long code;
    private Client client;
    private List<Item> itemList;
    private double total;

    public Ticket(Long code, Client client, List<Item> itemList, double total) {
        this.code = code;
        this.client = client;
        this.itemList = itemList;
        this.total = total;
    }

    public Ticket() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "code=" + code +
                ", client=" + client +
                ", itemList=" + itemList +
                ", total=" + total +
                '}';
    }
}
