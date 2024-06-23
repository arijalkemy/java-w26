package com.mercadolibre.sprint_3_valderrama.integration;

import com.mercadolibre.sprint_3_valderrama.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_valderrama.dto.request.RegisterRequestDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
public class AuthenticationControllerTest extends ControllerTest {

    String tokenUser;
    String tokenAdmin;
    RegisterRequestDTO registerRequestDTO;
    RegisterRequestDTO registerAdminRequestDTO;
    LoginRequestDTO loginRequestDTO;
    LoginRequestDTO loginAdminRequestDTO;

    private HttpEntity<String> getAuthorizedRequestEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        return new HttpEntity<>("parameters", headers);
    }

    @BeforeEach
    void setUp() throws JSONException {
        registerRequestDTO = RegisterRequestDTO.builder()
                .username("test")
                .password("test")
                .firstName("test")
                .lastName("test")
                .build();

        registerAdminRequestDTO = RegisterRequestDTO.builder()
                .username("admin1")
                .password("admin1")
                .firstName("admin1")
                .lastName("admin1")
                .build();
    }

    @Test
    void registerUserTestAndLogin() throws JSONException {

        HttpEntity<RegisterRequestDTO> requestEntity = new HttpEntity<>(registerRequestDTO);

        ResponseEntity<String> responseEntity =
                this.testRestTemplate.exchange(
                        "/auth/register", HttpMethod.POST, requestEntity, String.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        loginRequestDTO = LoginRequestDTO.builder()
                .username("test")
                .password("test")
                .build();

        HttpEntity<LoginRequestDTO> requestLoginEntity = new HttpEntity<>(loginRequestDTO);
        responseEntity =
                this.testRestTemplate.exchange(
                        "/auth/login", HttpMethod.POST, requestLoginEntity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        String body = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(body);
        tokenUser =  jsonObject.getString("token");

        responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/demo", HttpMethod.GET, getAuthorizedRequestEntity(tokenUser), String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Welcome from secure endpoint 1", responseEntity.getBody());

    }



    @Test
    void registerAdminTestAndLogin() throws JSONException {

        HttpEntity<RegisterRequestDTO> requestEntity = new HttpEntity<>(registerAdminRequestDTO);

        ResponseEntity<String> responseEntity =
                this.testRestTemplate.exchange(
                        "/auth/registerAdmin", HttpMethod.POST, requestEntity, String.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        loginAdminRequestDTO = LoginRequestDTO.builder()
                .username("admin1")
                .password("admin1")
                .build();

        HttpEntity<LoginRequestDTO> requestLoginEntity = new HttpEntity<>(loginAdminRequestDTO);
        responseEntity =
                this.testRestTemplate.exchange(
                        "/auth/login", HttpMethod.POST, requestLoginEntity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        String body = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(body);
        tokenAdmin =  jsonObject.getString("token");

        responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/demoAdmin", HttpMethod.GET, getAuthorizedRequestEntity(tokenAdmin), String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Welcome from secure endpointAdmin 1", responseEntity.getBody());

    }

    @Test
    void notSecuredTest() {
        ResponseEntity<String> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/index2", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Welcome from a Not SECURED endpoint!", responseEntity.getBody());
    }

}
