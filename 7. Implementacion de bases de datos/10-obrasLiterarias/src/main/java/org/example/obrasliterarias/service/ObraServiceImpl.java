package org.example.obrasliterarias.service;

import org.example.obrasliterarias.model.Obra;
import org.example.obrasliterarias.model.dto.ObraRequestDTO;
import org.example.obrasliterarias.model.dto.ObraResponseDTO;
import org.example.obrasliterarias.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraServiceImpl implements IObraService {

    @Autowired
    IObrasRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public ObraResponseDTO create(ObraRequestDTO obraDTO) {
        Obra obra = repository.save(mapToEntity(obraDTO));
        return mapToDTO(obra);
    }

    @Override
    public List<ObraResponseDTO> findObraByAutor(String autor) {
        List<Obra> listObras = repository.findObrasByAutor(autor);
        return listObras.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ObraResponseDTO> findObraByTitle(String titulo) {
        List<Obra> listObras = repository.findObrasByNombreContains(titulo);
        return listObras.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ObraResponseDTO> findObraByPaginas() {
        List<Obra> listObras = repository.findTop05ByOrderByPaginasDesc();
        return listObras.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ObraResponseDTO> findObraByAnioPublicacion(Integer anio) {
        List<Obra> listObras = repository.findObrasByAnioPublicacionBefore(anio);
        return listObras.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ObraResponseDTO> findObraByEditorial(String editorial) {
        List<Obra> listObras = repository.findObrasByEditorial(editorial);
        return listObras.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ObraResponseDTO> bulk(List<ObraRequestDTO> obrasDTO) {
        List<Obra> obras = obrasDTO.stream().map(
                o -> repository.save(mapToEntity(o))
        ).toList();
        return obras.stream().map(this::mapToDTO).toList();
    }

    private ObraResponseDTO mapToDTO(Obra Obra) {
        return mapper.map(Obra, ObraResponseDTO.class);
    }

    private Obra mapToEntity(ObraRequestDTO ObraRequestDTO) {
        return mapper.map(ObraRequestDTO, Obra.class);
    }
}
