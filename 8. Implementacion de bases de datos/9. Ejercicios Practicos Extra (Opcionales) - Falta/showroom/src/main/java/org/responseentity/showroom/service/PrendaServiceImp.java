package org.responseentity.showroom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.responseentity.showroom.dto.PrendaDTO;
import org.responseentity.showroom.dto.PrendaDTORequest;
import org.responseentity.showroom.model.Prenda;
import org.responseentity.showroom.repository.IPrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImp {

    @Autowired
    private IPrendaRepository prendaRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public PrendaDTO createNewClothes(PrendaDTORequest prendaDTO){
        Prenda prenda = mapper.convertValue(prendaDTO, Prenda.class);
        return mapper.convertValue(prendaRepository.save(prenda), PrendaDTO.class);
    }

    public List<PrendaDTO> getAllClothes(){
        return prendaRepository.findAll()
                .stream()
                .map(prenda -> mapper.convertValue(prenda, PrendaDTO.class))
                .toList();
    }

    public PrendaDTO getClothesByCode(Long code){
        return mapper.convertValue(prendaRepository.findById(code).orElse(null), PrendaDTO.class);
    }

    public List<PrendaDTO> getAllClothesBySize(String talla){
        return prendaRepository.findAllByTalla(talla)                .stream()
                .map(prenda -> mapper.convertValue(prenda, PrendaDTO.class))
                .toList();

    }

    public PrendaDTO updateClothes(Long id, PrendaDTORequest prendaDTO){
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        prenda.setNombre(prendaDTO.getNombre());
        prenda.setTipo(prendaDTO.getTipo());
        prenda.setMarca(prendaDTO.getMarca());
        prenda.setColor(prendaDTO.getColor());
        prenda.setTalla(prendaDTO.getTalla());
        prenda.setCantidad(prendaDTO.getCantidad());
        prenda.setPrecioVenta(prendaDTO.getPrecioVenta());
        return mapper.convertValue(prendaRepository.save(prenda), PrendaDTO.class);
    }

    public void deleteClothesById(Long id){
        prendaRepository.deleteById(id);
    }


}
