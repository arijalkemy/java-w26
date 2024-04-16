package com.example.demo.Athletes.Application.service;

import com.example.demo.Athletes.Application.in.request.IPersonService;
import com.example.demo.Athletes.Application.mapper.PersonMapper;
import com.example.demo.Athletes.Application.out.IPersonFinds;
import com.example.demo.Athletes.Application.out.response.PersonSportResponse;
import com.example.demo.Athletes.Domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final PersonMapper personMapper;
    private final IPersonFinds personFinds;

    @Override
    public List<Person> findAll() {
        return personFinds.findAll();
    }

    @Override
    public List<Person> findByName(String name) {
        return personFinds.findByName(name);
    }

    @Override
    public List<PersonSportResponse> findBySport(String sport) {
        List<PersonSportResponse> responseList = personMapper.toPersonSportResponseList(personFinds.findBySport(sport)) ;
        return responseList;
    }
}
