package com.mercadolibre.fresh_market.controller;

import com.newrelic.api.agent.NewRelic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

  @Operation(summary = "Ping the application")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Application is running",
                  content = {
                          @Content(mediaType = "application/json")
                  }),
          @ApiResponse(responseCode = "500", description = "Application is not running",
                  content = {
                          @Content(mediaType = "application/json")
                  })
  })
  @GetMapping("/ping")
  public String ping() {
    NewRelic.ignoreTransaction();
    return "pong";
  }
}
