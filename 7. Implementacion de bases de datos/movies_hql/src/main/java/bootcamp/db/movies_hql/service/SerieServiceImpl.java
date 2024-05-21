package bootcamp.db.movies_hql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.db.movies_hql.model.Serie;
import bootcamp.db.movies_hql.repository.SerieRepository;

@Service
public class SerieServiceImpl implements SerieService{

    private final SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository){
        this.serieRepository = serieRepository;
    }
    
    @Override
    public List<Serie> searchAll() {
        return serieRepository.findAll();
    }

    @Override
    public Serie searchByTitle(String title) {
        return serieRepository.findSerieByTitle(title);
    }
}
