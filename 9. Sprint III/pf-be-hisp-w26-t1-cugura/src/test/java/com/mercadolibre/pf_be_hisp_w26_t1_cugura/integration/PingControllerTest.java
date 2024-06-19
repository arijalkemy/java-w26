package com.mercadolibre.pf_be_hisp_w26_t1_cugura.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AutoConfigureMockMvc(addFilters = false)
class PingControllerTest extends ControllerTest {

  @Test
  void ping() {
    ResponseEntity<String> responseEntity =
        this.testRestTemplate.exchange(
            "/ping", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("pong", responseEntity.getBody());
  }
}
