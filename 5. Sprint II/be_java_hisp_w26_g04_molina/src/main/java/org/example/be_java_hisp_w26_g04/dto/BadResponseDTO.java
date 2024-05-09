package org.example.be_java_hisp_w26_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BadResponseDTO {
  String message;
  int status;
}
