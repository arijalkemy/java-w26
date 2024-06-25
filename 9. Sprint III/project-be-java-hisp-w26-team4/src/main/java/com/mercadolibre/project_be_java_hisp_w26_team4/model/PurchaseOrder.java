package com.mercadolibre.project_be_java_hisp_w26_team4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn (name = "buyer", nullable = false)
    private User buyer;
    @Column (name = "status")
    private String status;
    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "product_order", joinColumns = @JoinColumn(name = "purchase_order_id"))
    private List<ProductOrder> productOrders;
}
