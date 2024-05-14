package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    public static final String USER_URI = "/users";

    @BeforeAll
    public static void init() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void postFollowerUserWithNegativeId() throws Exception {
        Buyer buyer = TestGeneratorUtil.createBuyerWithId(-1);
        Seller seller = TestGeneratorUtil.createSellerWithId(-2);

        mockMvc.perform(MockMvcRequestBuilders.post(USER_URI
                        + "/{userId}/follow/{userIdToFollow}", buyer.getId(), seller.getId())
                )
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertInstanceOf(
                        HandlerMethodValidationException.class, result.getResolvedException()))
                .andReturn();
    }


}
