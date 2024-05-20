package org.example.lasperlas.Service;

import org.example.lasperlas.DTO.CrearJoyaRequestDTO;
import org.example.lasperlas.DTO.CrearJoyaResponseDTO;
import org.example.lasperlas.DTO.ObtenerJoyaResponseDTO;
import java.util.List;

public interface IJoyaService {
    CrearJoyaResponseDTO nuevaJoya(CrearJoyaRequestDTO joyaDTO);
    List<ObtenerJoyaResponseDTO> traerJoyas();
    CrearJoyaResponseDTO vender(Long id);
    ObtenerJoyaResponseDTO actualizar(Long id, CrearJoyaRequestDTO joyaNuevaDTO);
}
