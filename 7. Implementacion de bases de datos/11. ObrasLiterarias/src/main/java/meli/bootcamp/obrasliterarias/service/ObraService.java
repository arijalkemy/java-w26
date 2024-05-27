package meli.bootcamp.obrasliterarias.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.obrasliterarias.model.ObraLiteraria;
import meli.bootcamp.obrasliterarias.repository.IObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService implements IObraService{

    private final IObraRepository obraRepository;

    @Override
    public ObraLiteraria create(ObraLiteraria obraLiteraria) {
        return obraRepository.save(obraLiteraria);
    }

    @Override
    public List<ObraLiteraria> getObraLiterariasByAutor(String autor) {
        return obraRepository.findObraLiterariasByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> getObraLiterariasByNombreContaining(String contenido) {
        return obraRepository.findObraLiterariasByNombreContaining(contenido);
    }

    @Override
    public List<ObraLiteraria> getTop5ByOrderByCantidadPaginasDesc() {
        return obraRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    @Override
    public List<ObraLiteraria> getAllByAnioPrimeraPublicacionBefore(Integer year) {
        return obraRepository.findAllByAnioPrimeraPublicacionBefore(year);
    }

    @Override
    public List<ObraLiteraria> getAllByEditorialEqualsIgnoreCase(String editorial) {
        return obraRepository.findAllByEditorialEqualsIgnoreCase(editorial);
    }
}
