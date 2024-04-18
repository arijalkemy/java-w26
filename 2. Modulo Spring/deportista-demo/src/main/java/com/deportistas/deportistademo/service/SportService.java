package com.deportistas.deportistademo.service;

import com.deportistas.deportistademo.entity.Sport;
import com.deportistas.deportistademo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    IRepository<Sport> sportIRepository;

    @Autowired
    public SportService(IRepository<Sport> sportIRepository) {
        this.sportIRepository = sportIRepository;
    }

    public List<Sport> findAll(){
       return this.sportIRepository.findAll();
    }

    public Sport getByName(String name){
        Optional<Sport> response = this.sportIRepository.find(name);
        if(response.isPresent()){
            return response.get();
        }
        else{
            return new Sport();
        }
    }
}
