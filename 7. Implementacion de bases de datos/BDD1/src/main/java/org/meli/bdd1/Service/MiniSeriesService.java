package org.meli.bdd1.Service;

import org.meli.bdd1.Entity.MiniSeries;

import java.util.List;

public interface MiniSeriesService {
    List<MiniSeries> getAll();

    Long create(MiniSeries miniSeries);
}
