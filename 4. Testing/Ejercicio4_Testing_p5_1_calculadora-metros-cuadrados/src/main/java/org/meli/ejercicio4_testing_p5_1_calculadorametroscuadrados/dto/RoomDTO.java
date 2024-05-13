package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomDTO {
  @NotEmpty(message = "El nombre no puede ser nulo")
  private String name;
  @Min(value = 1, message = "El tamaño debe ser mayor a 0")
  @NotNull(message = "El tamaño no puede ser nulo")
  private Integer width;
  @Min(value = 1, message = "El tamaño debe ser mayor a 0")
  @NotNull(message = "El tamaño no puede ser nulo")
  private Integer length;

  public RoomDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
