package com.example.demo.Athletes.Application.service;

import com.example.demo.Athletes.Application.in.request.ISportsService;
import com.example.demo.Athletes.Application.out.ISportFinds;
import com.example.demo.Athletes.Domain.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements ISportsService {

    private final ISportFinds sportCRUD;

    @Override
    public List<Sport> findAll() {
        return sportCRUD.findAll();
    }

    @Override
    public Sport findByName(String name) {
        return sportCRUD.findByName(name);
    }
}
