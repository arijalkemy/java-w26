package org.responseentity.lasperlas.service;

import org.responseentity.lasperlas.dto.JoyaDTO;
import org.responseentity.lasperlas.dto.MessageResponse;

import java.util.List;

public interface IJewerlyService {
    public MessageResponse createJewerly(JoyaDTO joyaDTO);
    public List<JoyaDTO> listAllJewels();
    public MessageResponse deleteJewerly(Long id);
    public JoyaDTO updateJewel(Long id, JoyaDTO joyaDTO);
}
