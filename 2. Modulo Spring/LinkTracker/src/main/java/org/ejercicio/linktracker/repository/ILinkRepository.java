package org.ejercicio.linktracker.repository;

import org.ejercicio.linktracker.entity.Link;

import java.util.Map;
import java.util.UUID;

public interface ILinkRepository {
    Link findById(UUID id);
    Link save(Link link);
}
