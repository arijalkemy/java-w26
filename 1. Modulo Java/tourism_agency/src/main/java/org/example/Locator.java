package org.example;

import java.util.Iterator;
import java.util.List;

public class Locator {
    private Client client;
    private double total;
    private List<TouristicPackage> touristicPackages;

    public Locator(Client client, double total, List<TouristicPackage> touristicPackages) {
        this.client = client;
        this.total = total;
        this.touristicPackages = touristicPackages;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<TouristicPackage> getTouristicPackages() {
        return touristicPackages;
    }

    public void setTouristicPackages(List<TouristicPackage> touristicPackages) {
        this.touristicPackages = touristicPackages;
    }

    public String getTouristicPackagesDetails() {
        String detailsBody = "";
        for (TouristicPackage aPackage : this.touristicPackages) {
            detailsBody += aPackage.getDisplayName()+
                    " - " + aPackage.getQuantity()+"\n";
        }
        return "Detalles del paquete:\n" +
                detailsBody;
    }

    public void printDetails(){
        System.out.println(client.getFullName()+" | DNI: "+client.getDni()+"\n"+
                getTouristicPackagesDetails()+
                "Total: "+this.total);
    }
}
