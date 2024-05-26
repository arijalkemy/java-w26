package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.responseentity.elasticspring.dto.ObraLiterariaDTO;
import org.responseentity.elasticspring.repository.ObraLiterariaRepository;
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
        Iterable<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findAllByAuthor(autor);

        Stream<ObraLiteraria> obraLiterariaStream = StreamSupport.stream(obrasLiterarias.spliterator(), false);

        List<ObraLiterariaDTO> obraLiterariaDTOs = obraLiterariaStream
                .map(obra -> new ObraLiterariaDTO(
                        obra.getId(),
                        obra.getNombre(),
                        obra.getAutor(),
                        obra.getCantidadPaginas(),
                        obra.getEditorial(),
                        obra.getAnioPrimerPublicacion()
                ))
                .collect(Collectors.toList());

        return obraLiterariaDTOs;
    }

    @Override
    public List<ObraLiterariaDTO> findKeywordInTitle(String nombre) {
        Iterable<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findObraLiterariaByNombreContains(nombre);

        Stream<ObraLiteraria> obraLiterariaStream = StreamSupport.stream(obrasLiterarias.spliterator(), false);
        List<ObraLiterariaDTO> obraLiterariaDTOs = obraLiterariaStream
                .map(obra -> new ObraLiterariaDTO(
                        obra.getId(),
                        obra.getNombre(),
                        obra.getAutor(),
                        obra.getCantidadPaginas(),
                        obra.getEditorial(),
                        obra.getAnioPrimerPublicacion()
                ))
                .collect(Collectors.toList());

        return obraLiterariaDTOs;
    }

    @Override
    public List<ObraLiterariaDTO> findTopFivePages() {

        Iterable<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();

        Stream<ObraLiteraria> obraLiterariaStream = StreamSupport.stream(obrasLiterarias.spliterator(), false);
        List<ObraLiterariaDTO> obraLiterariaDTOs = obraLiterariaStream
                .map(obra -> new ObraLiterariaDTO(
                        obra.getId(),
                        obra.getNombre(),
                        obra.getAutor(),
                        obra.getCantidadPaginas(),
                        obra.getEditorial(),
                        obra.getAnioPrimerPublicacion()
                ))
                .collect(Collectors.toList());

        return obraLiterariaDTOs;
    }

    @Override
    public List<ObraLiterariaDTO> findPreviousYear(Integer year) {

        Iterable<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findObraLiterariaByAnioPrimerPublicacionBefore(year);

        Stream<ObraLiteraria> obraLiterariaStream = StreamSupport.stream(obrasLiterarias.spliterator(), false);
        List<ObraLiterariaDTO> obraLiterariaDTOs = obraLiterariaStream
                .map(obra -> new ObraLiterariaDTO(
                        obra.getId(),
                        obra.getNombre(),
                        obra.getAutor(),
                        obra.getCantidadPaginas(),
                        obra.getEditorial(),
                        obra.getAnioPrimerPublicacion()
                ))
                .collect(Collectors.toList());

        return obraLiterariaDTOs;
    }

    @Override
    public List<ObraLiterariaDTO> findAllByEditorial(String editorial) {

        Iterable<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findObraLiterariasByEditorial(editorial);

        Stream<ObraLiteraria> obraLiterariaStream = StreamSupport.stream(obrasLiterarias.spliterator(), false);
        List<ObraLiterariaDTO> obraLiterariaDTOs = obraLiterariaStream
                .map(obra -> new ObraLiterariaDTO(
                        obra.getId(),
                        obra.getNombre(),
                        obra.getAutor(),
                        obra.getCantidadPaginas(),
                        obra.getEditorial(),
                        obra.getAnioPrimerPublicacion()
                ))
                .collect(Collectors.toList());

        return obraLiterariaDTOs;
    }
}
