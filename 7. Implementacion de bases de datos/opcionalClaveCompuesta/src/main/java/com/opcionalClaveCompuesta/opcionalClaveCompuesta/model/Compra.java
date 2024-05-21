package com.opcionalClaveCompuesta.opcionalClaveCompuesta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table( name = "compras")
@IdClass(value= CompraKey.class)
@Getter @Setter
public class Compra {
    @Id
    private Long client_id;
    @Id
    private LocalDateTime date;
    private int amount;
}
//INSERTO EN H2 USANDO por ej:
//INSERT INTO COMPRAS (AMOUNT,CLIENT_ID,DATE) VALUES (80,1,CURRENT_TIMESTAMP)