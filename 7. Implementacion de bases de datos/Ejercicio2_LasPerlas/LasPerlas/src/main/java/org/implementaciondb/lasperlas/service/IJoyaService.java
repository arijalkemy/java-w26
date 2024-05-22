package org.implementaciondb.lasperlas.service;


import org.implementaciondb.lasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public String saveJoya(Joya joya);

    public List<Joya> getJoyas();

    public Joya findJoya(Long id);

    public String deleteJoya(Long id);

    public String editJoya(Long id_modificar, Joya joya_modif);

}
