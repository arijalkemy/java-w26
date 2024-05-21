package com.meli.Obras.literarias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.Obras.literarias.dto.ObraDto;
import com.meli.Obras.literarias.model.Obra;
import com.meli.Obras.literarias.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraServiceImpl implements IObraService {

    @Autowired
    private ObraRepository obraRepository;

    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @Override
    public ObraDto crearObra(ObraDto obraDto) {
        Obra obra = mapper.convertValue(obraDto, Obra.class);
        obraRepository.save(obra);
        return obraDto;
    }

    @Override
    public List<ObraDto> getObrasByAutor(String autor) {
        List<Obra> obras = obraRepository.findByAutor(autor);

        return mapObrasToObrasDto(obras);
    }

    @Override
    public List<ObraDto> getObrasByTitulo(String titulo) {
        List<Obra> obras = obraRepository.findByNombreLike(titulo);

        return mapObrasToObrasDto(obras);
    }

    @Override
    public List<ObraDto> getObrasConMasCantidadDePaginas() {
        List<Obra> obrasConMayorCantDePaginas = obraRepository.findAllByOrderByCantidadDePaginasDesc().stream()
                .limit(5).toList();

        return mapObrasToObrasDto(obrasConMayorCantDePaginas);
    }

    @Override
    public List<ObraDto> getObrasByFechaPublicacion(int anio) {
        List<Obra> obras = obraRepository.findByFechaPublicacionLessThanEqual(anio);
        return mapObrasToObrasDto(obras);
    }

    @Override
    public List<ObraDto> getObrasByEditorial(String editorial) {
        List<Obra> obras = obraRepository.findByEditorial(editorial);
        return mapObrasToObrasDto(obras);
    }

    private List<ObraDto> mapObrasToObrasDto(List<Obra> obras) {
        return obras.stream().map(
                obra -> mapper.convertValue(obra, ObraDto.class)).toList();
    }
}
