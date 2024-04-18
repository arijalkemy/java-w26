package com.EjercicioSpring.Ejercicio13_LinkTracker.repository;

import com.EjercicioSpring.Ejercicio13_LinkTracker.entity.Link;

public interface ILinkRepository {

    public boolean addLink(Link link);
    public Link getLinkById(Integer linkId);
    public boolean updateValidationLink(Link link);
    public boolean updateCount(Integer linkId);
    public int getSize();

}
