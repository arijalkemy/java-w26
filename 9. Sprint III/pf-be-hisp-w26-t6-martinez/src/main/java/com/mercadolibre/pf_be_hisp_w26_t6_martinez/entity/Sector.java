package com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sectors")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sector_code")
    private Long sectorCode;

    @Column(name = "remaining_capacity")
    private Integer remainingCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private StorageType storageType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_code")
    private List<Batch> batches;
}
