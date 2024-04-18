package com.athletes.bootcamp.services.implementations;

import com.athletes.bootcamp.classes.Sport;
import com.athletes.bootcamp.repositories.Repository;
import com.athletes.bootcamp.services.ISportsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsServiceImpl implements ISportsService {
    @Override
    public List<Sport> getSports() {
        return Repository.sports;
    }
}
