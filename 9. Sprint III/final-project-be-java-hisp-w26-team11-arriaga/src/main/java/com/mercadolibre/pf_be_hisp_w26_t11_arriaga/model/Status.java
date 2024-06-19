package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String statusCode;

    @OneToMany(mappedBy = "status")
    private Set<PurchaseOrder> purchaseOrders;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}