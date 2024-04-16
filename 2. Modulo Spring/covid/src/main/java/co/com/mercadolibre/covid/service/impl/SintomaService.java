package co.com.mercadolibre.covid.service.impl;

import co.com.mercadolibre.covid.entity.Sintoma;
import co.com.mercadolibre.covid.repository.ISintomaRepository;
import co.com.mercadolibre.covid.service.ISintomaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaService implements ISintomaService {

    private ISintomaRepository sintomaRepository;

    public SintomaService(ISintomaRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
    }
    @Override
    public List<Sintoma> buscarTodos() {
        return this.sintomaRepository.buscarTodos();
    }

    @Override
    public Sintoma buscarPorNombre(String nombre) {
        return this.sintomaRepository.buscarPorNombre(nombre).get();
    }
}
