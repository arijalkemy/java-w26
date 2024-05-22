package com.showroom.showroom.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClothRequestDTO {
   private Long idCloth;
   private int quantity;
}
