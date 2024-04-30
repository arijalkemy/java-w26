package com.mercadolibre.calculadorametroscuadrados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosApplicationTests {
  /*
  Ejercicio 1
Se solicita verificar la funcionalidad de la aplicación y crear los test unitarios
correspondientes para las capas de controladores y servicios. Agregar los escenarios
necesarios para obtener la mayor cobertura de código posible, comprobando que el
comportamiento esperado de cada unidad se cumpla correctamente. Se deben identificar
las dependencias de cada clase y mockearlas en caso de ser necesario para poder
testearlas unitariamente.

A continuación se indican algunos escenarios sugeridos:
- Escenario de entrada:
  Comportamiento esperado

- Verificar el cálculo del valor de la propiedad:
  Devuelve el cálculo correcto del valor de la propiedad basado en la cantidad de
  metros cuadrados

- Verificar que la habitación con las mayores dimensiones sea considerada la más grande:
  Retornar los datos de la habitación más grande basado en las propiedades “width” y “height”

- Verificar la cantidad de metros cuadrados por habitación:
  Devolver la cantidad correcta de metros cuadrados por habitación


Ejercicio 2
Se requiere crear los tests de integración necesarios para cubrir el comportamiento
de la capa de los controladores. Tener en cuenta la mayor cantidad de escenarios posibles.


Ejercicio 3
Luego de finalizados los ejercicios (y prácticas) anteriores verificar que se haya
obtenido una cobertura de código (code coverage) del 80% como mínimo. De no alcanzarse
ese nivel, revisar tanto los Tests de Unidad (con y sin Mocks) como los Tests de Integración
hasta que se logre el estándar requerido.
   */
  @Autowired
  private MockMvc mockMvc;

  // a) Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
  @Test
  void calculateHouseWithOneRoom() throws Exception {
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
            getRoom("Espacio abierto", 3, 3) +
            "]}";
    this.mockMvc.perform(
                    post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("9")));
  }

  @Test
  void calculateHouseWithMultipleRoom() throws Exception {
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
            getRoom("Espacio abierto", 5, 5) + "," +
            getRoom("Cocina", 3, 3) + "," +
            getRoom("Baño", 2, 1) +
            "]}";
    this.mockMvc.perform(
                    post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("36")));
  }

  //b) Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
  @Test
  void calculateHousePrice() throws Exception {
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
            getRoom("Espacio abierto", 5, 5) + "," +
            getRoom("Cocina", 3, 3) + "," +
            getRoom("Baño", 2, 1) +
            "]}";
    this.mockMvc.perform(
                    post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("36")))
            .andExpect(jsonPath("$.price").value(28800));
  }

  //c) Retornar el objecto con la habitacion mas grande.
  @Test
  void calculateBiggestRoom() throws Exception {
    String biggestRoom = "Espacio abierto";
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
            getRoom(biggestRoom, 5, 5) + "," +
            getRoom("Cocina", 3, 3) + "," +
            getRoom("Baño", 2, 1) +
            "]}";
    this.mockMvc.perform(
                    post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.biggest.name").value(biggestRoom));
  }

  //d) Retornar la cantidad de metros cuadrados por habitación.
  @Test
  void calculateRoomsSquareFeet() throws Exception {
    String biggestRoom = "Espacio abierto";
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
            getRoom(biggestRoom, 5, 5) + "," +
            getRoom("Cocina", 3, 3) + "," +
            getRoom("Baño", 2, 1) +
            "]}";
    this.mockMvc.perform(
                    post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
            .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
            .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
  }


  private String getRoom(String name, int width, int length) {
    return "{\"name\": \"" + name + "\", \"width\": " + width + ", \"length\": " + length + "}";
  }

}
