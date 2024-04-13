package com.example.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.store.Invoice;

public class InvoiceCRUD implements ICrud<Invoice> {

    List<Invoice> invoiceRepository;

    public InvoiceCRUD() {
        invoiceRepository = new ArrayList<>();
    }

    @Override
    public void save(Invoice invoice) {
        try {
            invoiceRepository.add(invoice);
        } catch (Exception e) {
            System.out.println("La factura no fue guardada - Error: " + e.getMessage());
        }
    }

    @Override
    public void show(Invoice invoice) {
        System.out.println(invoice.toString());
    }

    @Override
    public Optional<Invoice> get(String id) {
        for (Invoice invoice : invoiceRepository) {
            if (invoice.getInvoiceId().equals(id)) {
                return Optional.of(invoice);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        for (Invoice invoice : invoiceRepository) {
            if (invoice.getInvoiceId().equals(id)) {
                invoiceRepository.remove(invoice);
            }
        }
    }

    @Override
    public List<Invoice> getAll() {
        return this.invoiceRepository;
    }

}
