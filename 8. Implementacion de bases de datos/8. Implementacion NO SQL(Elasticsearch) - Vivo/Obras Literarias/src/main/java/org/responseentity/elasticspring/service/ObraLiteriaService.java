package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.responseentity.elasticspring.dto.ObraLiterariaDTO;
import org.responseentity.elasticspring.repository.ObraLiterariaRepository;
import org.responseentity.elasticspring.utils.mapper.ObraLiterariaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiteriaService implements IObraLiterariaService{
    @Autowired
    ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public List<ObraLiterariaDTO> findAllByAuthor(String autor) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>)obraLiterariaRepository.findAllByAutor(autor);
        return ObraLiterariaMapper.listaEntidadesAListaDTOs(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findKeywordInTitle(String nombre) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository.findObraLiterariaByNombreContains(nombre);
        return ObraLiterariaMapper.listaEntidadesAListaDTOs(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findTopFivePages() {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>)obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();
        return ObraLiterariaMapper.listaEntidadesAListaDTOs(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findPreviousYear(Integer year) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>)obraLiterariaRepository.findObraLiterariaByAnioPrimerPublicacionBefore(year);
        return ObraLiterariaMapper.listaEntidadesAListaDTOs(obrasLiterarias);
    }

    @Override
    public List<ObraLiterariaDTO> findAllByEditorial(String editorial) {
        List<ObraLiteraria> obrasLiterarias = (List<ObraLiteraria>) obraLiterariaRepository.findObraLiterariasByEditorial(editorial);
        return ObraLiterariaMapper.listaEntidadesAListaDTOs(obrasLiterarias);
    }
}
