package com.backendbootcamp.firstcrud.service;

import com.backendbootcamp.firstcrud.model.Jewel;
import com.backendbootcamp.firstcrud.model.ResponseDto;
import com.backendbootcamp.firstcrud.repository.JewelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JewelService implements IJewelService{

    private final JewelRepository repo;

    @Override
    public ResponseDto saveJewel(Jewel jewel) {
        jewel = repo.save(jewel);
        return new ResponseDto("joya creada correctamente con el id:" + jewel.getId());
    }

    @Override
    public List<Jewel> getAllJewels() {
        return null;
    }

    @Override
    public ResponseDto deleteJewel(Long id) {
        return null;
    }
}
