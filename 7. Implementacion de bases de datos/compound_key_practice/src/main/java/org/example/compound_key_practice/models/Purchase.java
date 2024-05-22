package org.example.compound_key_practice.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase")
public class Purchase {
    @EmbeddedId
    private PurchaseCompoundKey id;

    private Integer quantity;
    private Double total;
}
