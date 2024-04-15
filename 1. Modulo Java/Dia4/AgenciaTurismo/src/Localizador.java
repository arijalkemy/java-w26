public class Localizador {
    private String clienteId;
    private String detalles;
    private double total;

    public Localizador(String clienteId, String detalles, double total) {
        this.clienteId = clienteId;
        this.detalles = detalles;
        this.total = total;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getDetalles() {
        return detalles;
    }

    public double getTotal() {
        return total;
    }
}

