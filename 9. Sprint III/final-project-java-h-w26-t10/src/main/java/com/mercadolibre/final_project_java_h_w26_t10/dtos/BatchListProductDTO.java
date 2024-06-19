package com.mercadolibre.final_project_java_h_w26_t10.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchListProductDTO {
    private SectorDTO section;
    private Integer product_id;
    private List<BatchStockDTO> batch_stock;

}
