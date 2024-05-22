package org.implementaciondb.ejemplo5_onetomany.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sale_details")
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
