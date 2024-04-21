package org.example.link_tracer.repository;

import org.example.link_tracer.model.Link;

import java.util.*;

public interface ILinkRepository {
    Link add(Link newLink);
    Link findById(Integer id);
    List<Link> findAll();
}
