package org.example;

import java.util.ArrayList;
import java.util.List;

public class FacturaService implements CRUD<Factura> {
    private List<Factura> facturas;
    private ClientService clientService;

    public FacturaService(ClientService clientService) {
        this.facturas = new ArrayList<>();
        this.clientService = clientService;
    }

    @Override
    public void create(Factura factura) {
        Cliente cliente = clientService.read(factura.getCliente().getDni());
        if (cliente == null) {
            clientService.create(factura.getCliente());
        }

        double total = 0;
        for (Item item : factura.getItems()) {
            total += item.getPrecio();
        }
        factura.setTotal(total);

        facturas.add(factura);
    }

    @Override
    public Factura read(String id) {
        for (Factura factura : facturas) {
            if (factura.getId().equals(id)) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public void update(Factura facturaActualizada) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId().equals(facturaActualizada.getId())) {
                facturas.set(i, facturaActualizada);
                break;
            }
        }
    }

    @Override
    public void delete(String id) {
        facturas.removeIf(factura -> factura.getId().equals(id));
    }

    @Override
    public List<Factura> getAll() {
        return facturas;
    }

    @Override
    public String toString() {
        return "FacturaService{" +
                "facturas=" + facturas +
                ", clientService=" + clientService +
                '}';
    }
}