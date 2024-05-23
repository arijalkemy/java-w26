package com.example.demo.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
    
    private Double valorTotal;
   
    @EmbeddedId
    private CompraKey id;

    
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Compra() {
    }
    public Compra(Double valorTotal, CompraKey id) {
        this.valorTotal = valorTotal;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Compra [valorTotal=" + valorTotal + ", id=" + id + "]" + this.id;
    }

    
}
