package com.mercadolibre.linktracker.dto;

import lombok.Data;

@Data
public class LinkDTO {
  private Integer linkId;
  private String link;
  private String password;
  private Integer count;

  public LinkDTO() {
    this.count = 0;
  }

  public void sumCount() {
    count++;
  }
}