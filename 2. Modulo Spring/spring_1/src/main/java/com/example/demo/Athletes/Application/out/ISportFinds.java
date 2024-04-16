package com.example.demo.Athletes.Application.out;

import com.example.demo.Athletes.Domain.Sport;

import java.util.List;

public interface ISportFinds {
    List<Sport> findAll();
    Sport findByName(String name);
}
