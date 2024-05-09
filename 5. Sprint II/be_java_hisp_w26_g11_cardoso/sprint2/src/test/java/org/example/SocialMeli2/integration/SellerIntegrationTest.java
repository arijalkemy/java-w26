package org.example.SocialMeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.SocialMeli2.dto.ProductDTO;
import org.example.SocialMeli2.dto.RequestPostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // Objeto MockMvc para realizar solicitudes HTTP

    /**
     * Prueba la adición de una publicación de producto por un vendedor.
     * Simula una solicitud POST al endpoint /products/post.
     * Asegura que el estado de la respuesta sea OK y que el contenido devuelto sea el esperado.
     * @throws Exception si la solicitud HTTP simulada falla
     */
    @Test
    public void testAddPost() throws Exception {
        ProductDTO product = new ProductDTO(
                1, // product_id
                "Laptop", // product_name
                "Electronics", // type
                "Dell", // brand
                "Black", // color
                "Latest model with 16GB RAM" // notes
        );
        RequestPostDTO postDTO = new RequestPostDTO(
                101, // userId
                LocalDate.now(), // date
                product, // product DTO
                1, // category
                789.00 // price
        );

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        String jsonPostDTO = writer.writeValueAsString(postDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPostDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Prueba la obtención de todos los vendedores.
     * Simula una solicitud GET al endpoint /products/list.
     * Asegura que el estado de la respuesta sea OK y que el contenido devuelto sea JSON.
     * @throws Exception si la solicitud HTTP simulada falla
     */
    @Test
    public void testGetAllSellers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Prueba la obtención de publicaciones de vendedores seguidos con antigüedad de dos semanas.
     * Simula una solicitud GET al endpoint /products/followed/{userId}/list con un parámetro para el orden.
     * Asegura que el estado de la respuesta sea OK y que el contenido devuelto sea JSON, incluyendo la ID del usuario.
     * @throws Exception si la solicitud HTTP simulada falla
     */
    @Test
    public void testGetPostsFromFollowingWithTwoWeeksOld() throws Exception {
        int userId = 234;
        String order = "date_asc";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId));
    }
}
