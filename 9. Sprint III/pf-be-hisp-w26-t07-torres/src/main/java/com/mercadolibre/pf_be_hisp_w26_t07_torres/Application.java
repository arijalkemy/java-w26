package com.mercadolibre.pf_be_hisp_w26_t07_torres;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * Main class for the App.
 */
@EnableMethodSecurity
@SpringBootApplication
public class Application {

  /**
   * @param args command line arguments for the application.
   */
  public static void main(String[] args) {
    ScopeUtils.calculateScopeSuffix();
    new SpringApplicationBuilder(Application.class).registerShutdownHook(true).run(args);
  }

}
