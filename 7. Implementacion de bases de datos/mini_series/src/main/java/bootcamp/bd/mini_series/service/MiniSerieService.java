package bootcamp.bd.mini_series.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.bd.mini_series.model.MiniSerie;
import bootcamp.bd.mini_series.repository.IMiniserieReposity;

@Service
public class MiniSerieService {
    
    private final IMiniserieReposity miniserieReposity;

    public MiniSerieService(IMiniserieReposity miniserieReposity){
        this.miniserieReposity = miniserieReposity;
    }

    public List<MiniSerie> searchAll(){
        return miniserieReposity.findAll();
    }
}
