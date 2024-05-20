package com.mercadolibre.joyerialasperlas.service;

import com.mercadolibre.joyerialasperlas.dto.JewelDTO;
import com.mercadolibre.joyerialasperlas.dto.JewelResponseDTO;
import com.mercadolibre.joyerialasperlas.exception.JewelNotFoundException;
import com.mercadolibre.joyerialasperlas.model.Jewel;
import com.mercadolibre.joyerialasperlas.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class JewelServiceImpl implements IJewelService{
    IJewelRepository jewelRepository;

    public JewelServiceImpl(IJewelRepository jewelRepository){
        this.jewelRepository = jewelRepository;
    }

    @Override
    public Long createJewel(JewelDTO jewel) {
        Jewel toSave = new ModelMapper().map(jewel, Jewel.class);
        return jewelRepository.save(toSave).getId();
    }

    @Override
    public List<JewelResponseDTO> getAllJewels() {
        return getActiveJewelsStream()
                .map(jewel -> new ModelMapper().map(jewel, JewelResponseDTO.class))
                .toList();
    }

    @Override
    public JewelResponseDTO delete(Long id) {
        Jewel toDelete = findAndCheckJewelById(id);
        toDelete.setSellOrNot(false);
        jewelRepository.save(toDelete);
        return new ModelMapper().map(toDelete, JewelResponseDTO.class);
    }


    @Override
    public JewelResponseDTO updateJewel(Long id, JewelDTO updatedJewel) {
        Jewel toUpdate = findAndCheckJewelById(id);
        updateJewelAndSave(toUpdate, updatedJewel);
        return new ModelMapper().map(toUpdate, JewelResponseDTO.class);
    }
    
    private Jewel findAndCheckJewelById(Long id) {
        Jewel toFind = jewelRepository.findById(id).orElse(null);
        if(toFind == null){
            throw new JewelNotFoundException("Jewel with id " + id + " not found");
        }
        if(!toFind.getSellOrNot()){
            throw new JewelNotFoundException("Jewel with id " + id + " not found");
        }
        return toFind;
    }

    private void updateJewelAndSave(Jewel toUpdate, JewelDTO updatedJewel) {
        toUpdate.setName(updatedJewel.getName());
        toUpdate.setMaterial(updatedJewel.getMaterial());
        toUpdate.setQuirk(updatedJewel.getQuirk());
        toUpdate.setWeight(updatedJewel.getWeight());
        toUpdate.setHasStone(updatedJewel.getHasStone());
        toUpdate.setSellOrNot(updatedJewel.getSellOrNot());
        jewelRepository.save(toUpdate);
    }

    private Stream<Jewel> getActiveJewelsStream() {
        return jewelRepository.findAll().stream().filter(Jewel::getSellOrNot);
    }
}
