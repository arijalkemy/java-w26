package com.example.ejercicio_recapitulando_spring_p2_vivo.repository;

import com.example.ejercicio_recapitulando_spring_p2_vivo.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link save(Link link);
    Optional<Link> findLinkById(Integer id);
    void delete(Link link);
}
