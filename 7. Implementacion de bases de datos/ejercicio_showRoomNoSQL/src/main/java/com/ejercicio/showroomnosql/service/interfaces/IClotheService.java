package com.ejercicio.showroomnosql.service.interfaces;

import com.ejercicio.showroomnosql.dto.ClotheDTO;
import com.ejercicio.showroomnosql.dto.MessageResponseDTO;
import com.ejercicio.showroomnosql.entity.Clothe;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClotheService {
    MessageResponseDTO createClothe(ClotheDTO clotheDTO);
    List<Clothe> getAllClothes(Pageable pageable);
    Clothe getClotheByCode(String code);
    Clothe updateClothe(long code, ClotheDTO clotheDTO);
    MessageResponseDTO deleteClothe(long code);
    List<Clothe> getAllClothesByWaist(String waist);
    List<Clothe> getAllClothesByName(String name);
}
