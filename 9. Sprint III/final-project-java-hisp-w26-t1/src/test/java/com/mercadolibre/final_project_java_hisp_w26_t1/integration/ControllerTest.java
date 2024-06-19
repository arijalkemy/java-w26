package com.mercadolibre.final_project_java_hisp_w26_t1.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

@AutoConfigureMockMvc(addFilters = false)
public class ControllerTest extends IntegrationTest {
  @Autowired 
  protected TestRestTemplate testRestTemplate;

  protected <T> RequestEntity<T> getDefaultRequestEntity() {
    HttpHeaders headers = new HttpHeaders();
    return new RequestEntity<>(headers, HttpMethod.GET, null);
  }
}
