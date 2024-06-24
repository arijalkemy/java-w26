package com.mercadolibre.project_java_w26_team13.controller;

import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import com.newrelic.api.agent.NewRelic;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for /ping implementation.
 */
@RestController
@RequiredArgsConstructor
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
