package com.example.demo.model.dto.saleDTO;

import com.example.demo.model.entity.Clothes;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaleResponseDTO {

    private Long id;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothesList;

}
