package ejercicio.Crud.Service;

import ejercicio.Crud.DTO.Request.JewelRequestDto;
import ejercicio.Crud.DTO.Response.JewelResponseDto;
import java.util.List;


public interface IJewelService {
    JewelResponseDto saveJewel(JewelRequestDto jewelRequestDto);
    List<JewelResponseDto> getAllJewells();
    void deleteJewel(Long id);
    void updateJewel(JewelRequestDto jewelDtoRequest, Long id);
}
