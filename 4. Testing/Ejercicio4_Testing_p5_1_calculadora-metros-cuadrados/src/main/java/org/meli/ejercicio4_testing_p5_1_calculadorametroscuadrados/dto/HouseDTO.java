package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class HouseDTO {
  @NotEmpty(message = "El nombre no puede ser nulo")
  private String name;
  @NotEmpty(message = "La dirección no puede ser nula")
  private String address;
  private List<@Valid RoomDTO> rooms;

  public HouseDTO() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<RoomDTO> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }
}
