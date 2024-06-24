package com.mercadolibre.final_project_java_hisp_w26_t6.entity;

import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_code")
    private List<Batch> batches;
}
