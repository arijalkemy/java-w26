package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public Integer getSquareFeet() {
    if (this.width != null && this.length != null)
      return this.width * this.length;
    return 0;
  }
}
