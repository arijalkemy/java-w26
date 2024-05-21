package com.w26.testcase.testcase.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BadResponse implements Serializable{
    private String message;
    private String error;  
}
