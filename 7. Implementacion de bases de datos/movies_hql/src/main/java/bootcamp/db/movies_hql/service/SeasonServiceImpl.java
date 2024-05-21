package bootcamp.db.movies_hql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.db.movies_hql.model.Season;
import bootcamp.db.movies_hql.repository.SeasonRepository;

@Service
public class SeasonServiceImpl implements SeasonService{

    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository){
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> searchAll() {
        return seasonRepository.findAll();    
    }
    
}
