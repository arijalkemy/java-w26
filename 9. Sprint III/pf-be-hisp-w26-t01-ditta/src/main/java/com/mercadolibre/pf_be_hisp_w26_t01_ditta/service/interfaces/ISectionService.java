package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionResponseDTO;

import java.util.List;

public interface ISectionService {
    void save(SectionRequestDTO sectionRequestDTO, String managerEmail);

    List<SectionResponseDTO> getAll(String managerEmail);
}
