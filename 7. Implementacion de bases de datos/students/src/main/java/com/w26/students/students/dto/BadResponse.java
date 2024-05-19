package com.w26.students.students.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BadResponse implements Serializable {
    String message;
    int codeError;
}
