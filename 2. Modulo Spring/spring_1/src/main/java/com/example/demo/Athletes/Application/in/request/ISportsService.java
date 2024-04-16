package com.example.demo.Athletes.Application.in.request;

import com.example.demo.Athletes.Domain.Sport;

import java.util.List;

public interface ISportsService {
   List<Sport> findAll();
   Sport findByName(String name);
}
