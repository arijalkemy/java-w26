package com.mercadolibre.pf_be_hisp_w26_t1_cassini.integration;

import com.mercadolibre.restclient.mock.RequestMockHolder;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationTest {

  protected IntegrationTest() { }

  @AfterEach
  protected void afterEach() {
    RequestMockHolder.clear();
  }
}
