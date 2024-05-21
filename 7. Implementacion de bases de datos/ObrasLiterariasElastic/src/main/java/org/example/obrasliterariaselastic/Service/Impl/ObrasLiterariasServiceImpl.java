package org.example.obrasliterariaselastic.Service.Impl;

import org.example.obrasliterariaselastic.DTO.ObraLiterariaDTOResponse;
import org.example.obrasliterariaselastic.Model.ObraLiteraria;
import org.example.obrasliterariaselastic.Repository.IObraLiterariaRepository;
import org.example.obrasliterariaselastic.Service.IObrasLiterariasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObrasLiterariasServiceImpl implements IObrasLiterariasService {

    //@Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    public ObrasLiterariasServiceImpl(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    private ObraLiterariaDTOResponse obraLiterariaToDTOResponse(ObraLiteraria obra) {
        return ObraLiterariaDTOResponse
                .builder()
                .id(obra.getId())
                .nombre(obra.getNombre())
                .autor(obra.getAutor())
                .cantidadDePaginas(obra.getCantidadDePaginas())
                .editorial(obra.getEditorial())
                .anioPrimeraPublicacion(obra.getAnioPrimeraPublicacion())
                .build();
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerTodas() {
        List<ObraLiteraria> obrasLiterarias = this.obraLiterariaRepository.findAll();
        return obrasLiterarias.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerDeAutor(String autor) {
        List<ObraLiteraria> obrasDelAutor = this.obraLiterariaRepository.findByAutor(autor);
        return obrasDelAutor.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerPorTituloContiene(String keyword) {
        List<ObraLiteraria> obrasLiterarias = this.obraLiterariaRepository.findByNombreContains(keyword);
        return obrasLiterarias.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerTop5ObrasConMasPaginasOrdenadas() {
        List<ObraLiteraria> obrasLiterarias = this.obraLiterariaRepository.findTop5ByOrderByCantidadDePaginasDesc();
        return obrasLiterarias.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerPorAnioPrimeraPublicacionMenorA(Integer anio) {
        List<ObraLiteraria> obrasLiterarias = this.obraLiterariaRepository.findByAnioPrimeraPublicacionIsLessThan(anio);
        return obrasLiterarias.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTOResponse> obtenerPorEditorial(String editorial) {
        List<ObraLiteraria> obrasLiterarias = this.obraLiterariaRepository.findByEditorial(editorial);
        return obrasLiterarias.stream().map(this::obraLiterariaToDTOResponse).collect(Collectors.toList());
    }

}