package com.group03.sprint2.controller.unit;

import com.group03.sprint2.TestUtils;
import com.group03.sprint2.controller.PublicationsController;
import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.dto.response.ResponseIdPublicationsDTO;
import com.group03.sprint2.service.implementation.PublicationsServiceImpl;
import com.group03.sprint2.utils.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PublicationsControllerTest {
    static Integer buyerId;
    static Integer sellerId;
    static List<PublicationDTO> publicationsDTO;
    static ResponseIdPublicationsDTO responseIdPublicationsDTO;

    @Mock
    PublicationsServiceImpl publicationsService;

    @InjectMocks
    PublicationsController publicationsController;

    @BeforeAll()
    static void setup() throws Exception {
        buyerId = 12345;
        sellerId = 1;
        publicationsDTO = TestUtils.getPublicationDTOsFromLastTwoWeeks(sellerId);
        responseIdPublicationsDTO = new ResponseIdPublicationsDTO(buyerId, publicationsDTO);
    }

    void publicationsOrderTest(String order) {
        // Arrange
        when(publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order))
                .thenReturn(publicationsDTO);
        ResponseEntity<ResponseIdPublicationsDTO> expectedResponse = ResponseEntity.ok().body(responseIdPublicationsDTO);

        // Act
        ResponseEntity<ResponseIdPublicationsDTO> actualResponse =
                publicationsController.getFollowedLastTwoWeeksPublications(buyerId, order);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should show publications from last two weeks with out order")
    void getFollowedLastTwoWeeksPublicationsOKTest() throws IOException {
        publicationsOrderTest(null);
    }

    @Test
    @DisplayName("Verify correct order by date ascendant")
    void getFollowedLastTwoWeeksPublicationsOrderAscOKTest() throws IOException {
        publicationsOrderTest(Constants.ORDER_DATE_ASCENDANT);
    }

    @Test
    @DisplayName("Verify correct order by date descendant")
    void getFollowedLastTwoWeeksPublicationsOrderDescOKTest() throws IOException {
        publicationsOrderTest(Constants.ORDER_DATE_DESCENDANT);
    }


}