package com.example.movies_db.service;

import com.example.movies_db.dto.ActorDTO;
import com.example.movies_db.entity.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();
}
