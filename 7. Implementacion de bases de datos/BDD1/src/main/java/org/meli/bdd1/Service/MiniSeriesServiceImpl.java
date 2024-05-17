package org.meli.bdd1.Service;

import lombok.RequiredArgsConstructor;
import org.meli.bdd1.Entity.MiniSeries;
import org.meli.bdd1.Repository.MiniSeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniSeriesServiceImpl implements MiniSeriesService {

    private final MiniSeriesRepository miniSeriesRepo;


    @Override
    public List<MiniSeries> getAll() {
        return miniSeriesRepo.findAll();
    }

    @Override
    public Long create(MiniSeries miniSeries) {
        return miniSeriesRepo.save(miniSeries).getId();
    }
}
