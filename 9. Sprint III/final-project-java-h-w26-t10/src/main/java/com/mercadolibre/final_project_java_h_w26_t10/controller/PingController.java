package com.mercadolibre.final_project_java_h_w26_t10.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for /ping implementation.
 */
@RestController
public class PingController {

  /**
   * @return "pong" String.
   */
  @GetMapping("/ping")
  public String ping() {
    NewRelic.ignoreTransaction();
    return "pong";
  }
}
