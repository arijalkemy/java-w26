package org.example.dtosport.service.impl;

import org.example.dtosport.entity.dto.SportPersonDto;
import org.example.dtosport.service.ISportPerson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SportPersonImpl implements ISportPerson {

    private final List<SportPersonDto> sportPerson;

    public SportPersonImpl(@Qualifier("sportPerson") List<SportPersonDto> sportPerson) {
        this.sportPerson = sportPerson;
    }

    @Override
    public List<SportPersonDto> findSportPerson() {
        return this.sportPerson;
    }
}
