package com.example.link.repositorios.interfaces;

import com.example.link.modelo.Link;

import java.util.Optional;

public interface ILinkRepositorio {
    public void guardarLink(Link link);

    public Optional<Link> buscarPorId(int id);
}
