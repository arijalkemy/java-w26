import java.util.Arrays;
import java.util.List;

public class Agency {
    private List<Invoice> invoices;
    private List<Client> clients;
    public Agency(List<Invoice> invoices, List<Client> clients) {
        this.invoices = invoices;
        this.clients = clients;
    }

    public void assignDiscount(){
        int []invoiceClient = new int[this.clients.size()+1];
        Arrays.fill(invoiceClient, 0);
        for (Invoice invoice : this.invoices) {
            invoiceClient[invoice.getClient().getId()]++;
        }
        for (Client client : this.clients) {
            if(invoiceClient[client.getId()] >= 2){
                for(Invoice i: this.invoices) {
                    if(i.getClient().getId().equals(client.getId())){
                        i.getClient().setDiscount(true);
                    }
                }
            }
        }
    }

    public double getTotalClient(Integer id){
        System.out.println(invoices);
        return this.invoices.stream().filter(i -> i.getClient().getId().equals(id)).mapToDouble(Invoice::getPriceDiscount).sum();
    }
}
