package org.miprimerproyecto.joyerialasperlas.service;

import org.miprimerproyecto.joyerialasperlas.model.Jewel;

import java.util.List;

public interface IJewelService {
    public List<Jewel> getJewel();
    public void saveJewel(Jewel joy);
    public String deleteJewel(long id);
    public Jewel findJewel (long id);

    String editJewel(Long id_modificar, Jewel joya_modif);
}
