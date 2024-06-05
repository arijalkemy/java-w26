package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.controller;
import jakarta.validation.Valid;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseResponseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.RoomDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.service.CalculateService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateRestController {
  @PostMapping("/calculate")
  public HouseResponseDTO calculate(@RequestBody @Valid HouseDTO house){
    CalculateService calculateService = new CalculateService();
    return calculateService.calculate(house);
  }
}
