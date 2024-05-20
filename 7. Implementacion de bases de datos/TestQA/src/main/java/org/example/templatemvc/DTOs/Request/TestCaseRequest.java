package org.example.templatemvc.DTOs.Request;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record TestCaseRequest(String description, Boolean tested, Boolean passed,
                              LocalDate lastUpdate, int numberOfTries) {}
