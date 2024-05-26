package org.responseentity.lasperlas.service;

import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.responseentity.lasperlas.dto.JoyaDTO;
import org.responseentity.lasperlas.dto.MessageResponse;
import org.responseentity.lasperlas.model.Jewel;
import org.responseentity.lasperlas.repository.IJewerlyRepository;
import org.responseentity.lasperlas.utils.mapper.JewelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewerlyService implements IJewerlyService{

    @Autowired
    private IJewerlyRepository jewerlyRepository;

    @Override
    public MessageResponse createJewerly(JoyaDTO joyaDTO) {
        Jewel newJewel = jewerlyRepository.save(JewelMapper.dtoToEntity(joyaDTO));
        String message = String.format("id de la joya %s es: %d", newJewel.getName(), newJewel.getId());
        return MessageResponse
                .builder()
                .message(message)
                .build();
    }

    @Override
    public List<JoyaDTO> listAllJewels() {
        return jewerlyRepository.findAll().stream()
                .filter(jewel -> jewel.getIsForSale() == true)
                .map(jewel -> JewelMapper.entityToDTO(jewel))
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponse deleteJewerly(Long id) {
        Optional<Jewel> jewelOptional = jewerlyRepository.findById(id);

        /* existe la joya */
        if (jewelOptional.isEmpty()) {
            throw new RuntimeException("Jewel not found");
        }
        Jewel jewel = jewelOptional.get();

        /* joya ya se encuentra eliminada */
        if(!jewel.getIsForSale()){
            throw new RuntimeException("Jewel is already not for sale");
        }

        jewel.setIsForSale(false);
        jewerlyRepository.save(jewel);
        String message = String.format("La joya %s con el id %d ha dejado de estar a la venta", jewel.getName(), jewel.getId());
        return MessageResponse.builder().message(message).build();
    }

    @Override
    public JoyaDTO updateJewel(Long id,  JoyaDTO joyaDTO) {
        Optional<Jewel> jewelOptional = jewerlyRepository.findById(id);

        /* existe la joya */
        if (jewelOptional.isEmpty()) {
            throw new RuntimeException("Jewel not found");
        }

        Jewel jewel = jewelOptional.get();
        /* la joya ya no esta a la venta */
        if(!jewel.getIsForSale()){
            throw new RuntimeException("Jewel is not for sale");
        }

        jewel.setName(joyaDTO.getNombre());
        jewel.setMaterial(joyaDTO.getMaterial());
        jewel.setWeight(joyaDTO.getPeso());
        jewel.setParticularity(jewel.getParticularity());
        jewel.setHasStone(jewel.getHasStone());
        jewel.setIsForSale(jewel.getIsForSale());

        Jewel jewelUpdated = jewerlyRepository.save(jewel);
        return JewelMapper.entityToDTO(jewel);
    }
}
