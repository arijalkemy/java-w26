package org.example.integradorjpaclavecompuesta.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SaleKey {
    private Long id;
    private String date;
}
