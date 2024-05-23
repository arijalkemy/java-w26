package com.jewelry.perls.service;

import com.jewelry.perls.dto.JewerDto;
import com.jewelry.perls.entity.Jewer;

import java.util.List;

public interface IJewerService {

    List<Jewer> getAll();
    String saveJewer(JewerDto jewerDto);
    Jewer changeJewer(JewerDto jewerDto, Integer id);
    String deleteJewer(Integer id);
}
