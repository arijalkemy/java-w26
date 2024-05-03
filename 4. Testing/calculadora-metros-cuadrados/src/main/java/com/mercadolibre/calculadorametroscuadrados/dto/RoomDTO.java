package com.mercadolibre.calculadorametroscuadrados.dto;


public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO() {
  }


  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    RoomDTO that = (RoomDTO) obj;
    return name.equals(that.name) && width.equals(that.width) && length.equals(that.length);
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
