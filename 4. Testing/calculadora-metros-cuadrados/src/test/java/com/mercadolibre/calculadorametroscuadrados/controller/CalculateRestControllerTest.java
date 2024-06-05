    package com.mercadolibre.calculadorametroscuadrados.controller;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
    import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

    import java.util.List;

    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


    @SpringBootTest
    @AutoConfigureMockMvc
    public class CalculateRestControllerTest {

        @Autowired
        private MockMvc mockMvc;
        static ObjectMapper mapper;

        @BeforeAll
        static void setUp()
        {
            mapper = new ObjectMapper();
        }

        @Test
        void calculateTest() throws Exception
        {
            // arrange
            List<RoomDTO> room = List.of(
                    new RoomDTO("sala", 10, 10)
            );
            HouseDTO houseDto = new HouseDTO("Lomas de la estancia", "reforma 22",  room);

            // act and arrange
            mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                    .content(mapper.writeValueAsString(houseDto))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.squareFeet").value(100)
            );
        }
    }
