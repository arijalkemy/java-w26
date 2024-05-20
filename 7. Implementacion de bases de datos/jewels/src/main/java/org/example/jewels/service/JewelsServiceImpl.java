package org.example.jewels.service;

import lombok.RequiredArgsConstructor;
import org.example.jewels.dto.JewelDto;
import org.example.jewels.dto.SuccessDto;
import org.example.jewels.model.Jewel;
import org.example.jewels.repository.IJewelsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JewelsServiceImpl implements IJewelsService{
    @Autowired
    IJewelsRepository repository;

    @Override
    public SuccessDto createJewel(JewelDto newJewel) {
        ModelMapper mapper = new ModelMapper();
        Jewel mappedJewel = mapper.map(newJewel, Jewel.class);
        Jewel createdJewel = repository.save(mappedJewel);
        return new SuccessDto("Creado con id "+createdJewel.getId());
    }
}
