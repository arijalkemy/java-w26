package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindController {
  @Autowired
  private FindService findService;

  /*
  Ejercicio

Se solicita crear los test unitarios correspondientes para las capas de controladores,
servicios y repositorios. Agregar los escenarios necesarios para obtener la mayor
cobertura de código posible, comprobando que el comportamiento esperado de cada unidad
se cumpla correctamente.

Las clases candidatas para ser testeadas unitariamente son las siguientes:

FindController
CharacterRepositoryImpl
FindService

El mínimo de cobertura esperada por cada una de las clases nombradas es del 80%.
Se deben identificar las dependencias de cada clase y mockearlas en caso de ser necesario
para poder testearlas unitariamente.

Ejercicio 1
Se requiere crear los tests de integración necesarios para cubrir el comportamiento de
la capa de controladores FindController. Tener en cuenta la mayor cantidad de escenarios posibles.

Ejercicio 2
Luego de implementar los tests de integración, verificar que se haya obtenido una
cobertura de código (code coverage) del 80% como mínimo. De no alcanzarse ese nivel,
revisar tanto los Tests Unitarios como los Tests de Integración hasta que se logre el estándar requerido.
   */
  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
    return findService.find(query);
  }
}
