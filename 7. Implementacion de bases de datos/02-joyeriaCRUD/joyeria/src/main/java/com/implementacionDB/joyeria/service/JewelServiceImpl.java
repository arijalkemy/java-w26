package com.implementacionDB.joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.implementacionDB.joyeria.dto.JewellResponseDTO;
import com.implementacionDB.joyeria.dto.request.JewelDTO;
import com.implementacionDB.joyeria.dto.MessageDTO;
import com.implementacionDB.joyeria.exception.entity.NotFoundException;
import com.implementacionDB.joyeria.model.Jewel;
import com.implementacionDB.joyeria.repository.IJewelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JewelServiceImpl implements IJewelService{
    private final ObjectMapper mapper = new ObjectMapper();
    private final IJewelRepository jewelRepo;
    private final MessageDTO responseMsg = new MessageDTO();


    private Jewel findById(Long id){
        Jewel jewelById = jewelRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("There is not a jewell with id: " + id));
        return jewelById;
    }

    @Override
    @Transactional
    public List<JewellResponseDTO> getAll() {
        List<Jewel> listJewel = jewelRepo.findAll().stream().filter(j -> (j.getVentaONo())).toList();
        List<JewellResponseDTO> listResponse = listJewel.stream()
                .map(j -> mapper.convertValue(j, JewellResponseDTO.class))
                .collect(Collectors.toList());
        return listResponse;
    }

    @Override
    @Transactional
    public JewellResponseDTO getById(Long id) {
        Jewel jewelById = findById(id);
        return mapper.convertValue(jewelById, JewellResponseDTO.class);
    }

    @Override
    @Transactional
    public MessageDTO deleteJewel(Long id) {
        Jewel jewelToDelete = findById(id);
        jewelToDelete.setVentaONo(false);

        this.responseMsg.setMessage("Success deleting jewel with id: " + id);
        return this.responseMsg;
    }

    @Override
    @Transactional
    public MessageDTO addJewel(JewelDTO jewel) {
        Jewel jewelToSave = mapper.convertValue(jewel, Jewel.class);
        jewelRepo.save(jewelToSave);

        this.responseMsg.setMessage("Success saving jewel with id: " + jewelToSave.getNroIdentificatorio());
        return this.responseMsg;
    }

    @Override
    @Transactional
    public MessageDTO updateJewel(Long id, JewelDTO jewelDTO) {
        Jewel jewelToUpdate = findById(id);

        jewelToUpdate.setNombre(jewelDTO.getNombre());
        jewelToUpdate.setMaterial(jewelDTO.getMaterial());
        jewelToUpdate.setPeso(jewelDTO.getPeso());
        jewelToUpdate.setParticularidad(jewelDTO.getParticularidad());
        jewelToUpdate.setPoseePiedra(jewelDTO.getPoseePiedra());
        jewelRepo.save(jewelToUpdate);

        this.responseMsg.setMessage("Success updating jewel with id: " + jewelToUpdate.getNroIdentificatorio());

        return this.responseMsg;
    }
}
