package org.example.sprint1.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.sprint1.dto.ProductDTO;
import org.example.sprint1.dto.RequestPostDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas para SellerController.
 */

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Evalúa que se lanza la excepción 400 si no se envía ningún body en la petición POST.
     * @throws Exception si ocurre un error al realizar la petición o al evaluar las expectativas.
     */

    @Test
    @DisplayName("Evaluar que se lanza la exception 400 si no mando ningun body")
    public void addPostTestNoOk() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) jsonPath("$.message").exists())
                .andExpect((ResultMatcher) jsonPath("$.message").isString()
        );
    }

    /**
     * Evalua que el httpstatus 200 sea lanzado de manera correcta, cuando resive un jsonbody correcto
     */

    @Test
    @DisplayName("Verificar el estatus correcto del endpoint /products/post cuando se le manda un body aceptable")
    public void addPostTestOk() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        ProductDTO product =
                new ProductDTO(1001, "Mackbook Pro", "Tecnologia", "Apple", "Gray", "Apple m3 chip");
        RequestPostDTO requestPost = new RequestPostDTO(101, LocalDate.now(), product, 1, 54.000);


        String jsonBody = mapper.writeValueAsString(requestPost);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post", requestPost)
                .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk()
        );
    }


    /**
     * Valida la respuesta de obtener un listado de todos los sellers junto con sus respectivos productos.
     * @throws Exception si ocurre un error al realizar la petición o al evaluar las expectativas.
     */

    @Test
    @DisplayName("Validar la respuesta de obtener un listado de todos los sellers junto con sus respectivos productos")
    public void getAllSellersTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isArray()
        );
    }

    /**
     * Verifica que el código devuelto sea 404 al enviar un id que no corresponde a un usuario.
     * @throws Exception si ocurre un error al realizar la petición o al evaluar las expectativas.
     */

    @Test
    @DisplayName("Verificar que el codigo devuelto sea 404 al mandar un id que no corresponda a un usuario")
    public void getPostsFromFollowingWithTwoWeeksOldTestFail() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) status().isNotFound())
                .andExpect((ResultMatcher) jsonPath("$.message").exists())
                .andExpect((ResultMatcher) jsonPath("$.message").isString()
        );
    }

    /**
     * Verifica que al enviar 234 como id se regrese el formato correcto de la respuesta.
     * @throws Exception si ocurre un error al realizar la petición o al evaluar las expectativas.
     */

    @Test
    @DisplayName("Verificar al mandar 234 como id me regrese el formato correcto")
    public void getPostsFromFollowingWithTwoWeeksOldTestOkWay() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list", 234)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.posts").isArray())
                .andExpect((ResultMatcher) jsonPath("$.posts").isNotEmpty())
                .andExpect((ResultMatcher) jsonPath("$.posts.length()").value(1))
                .andExpect((ResultMatcher) jsonPath("$.posts[0].has_promo").value(false)
        );
    }
}
