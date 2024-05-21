package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.responseentity.elasticspring.dto.ObraLiterariaDTO;
import org.responseentity.elasticspring.repository.ObraLiterariaRepository;
import org.responseentity.elasticspring.utils.ObraLiterariaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ObraLiteriaService implements IObraLiterariaService{
    @Autowired
    ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public List<ObraLiterariaDTO> findAllByAuthor(String autor) {
        List<ObraLiteraria> obrasLiterarias =(List<ObraLiteraria>) obraLiterariaRepository
                                                                        .findAllByAuthor(autor);

        return ObraLiterariaMapper.mapToObraLiterariaDtoList(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findKeywordInTitle(String nombre) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository
                                                                        .findObraLiterariaByNombreContains(nombre);

        return ObraLiterariaMapper.mapToObraLiterariaDtoList(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findTopFivePages() {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository
                                                                        .findTop5ByOrderByCantidadPaginasDesc();

        return ObraLiterariaMapper.mapToObraLiterariaDtoList(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findPreviousYear(Integer year) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository
                                                            .findObraLiterariaByAnioPrimerPublicacionBefore(year);

        return ObraLiterariaMapper.mapToObraLiterariaDtoList(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findAllByEditorial(String editorial) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository
                                                            .findObraLiterariasByEditorial(editorial);

        return ObraLiterariaMapper.mapToObraLiterariaDtoList(obrasLiterarias);
    }
}
