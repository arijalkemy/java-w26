package com.tracker.link.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Contador {
    Map<Integer, Integer> contador = new HashMap<Integer, Integer>();

}
