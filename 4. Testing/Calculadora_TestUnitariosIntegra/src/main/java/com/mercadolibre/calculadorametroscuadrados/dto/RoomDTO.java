package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }

  @Override
  public String toString() {
    return "RoomDTO{" +
            "name='" + name + '\'' +
            ", width=" + width +
            ", length=" + length +
            '}';
  }
}
