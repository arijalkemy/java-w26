package org.responseentity.responseentity.services.sport;

import java.util.List;

public interface ISportService {
    public List<SportDTO> getSports();
    public SportDTO findSportByName(String sportName);
    public void insertSport(SportDTO sport);
    public List<SportDTO> deleteSporte(String sportName);
}
