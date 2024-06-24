package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.ISectionRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ICategoryServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ISectionService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IUserServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IWarehouseServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService implements ISectionService {

    private final ISectionRepository sectionRepository;
    private final ICategoryServiceInternal categoryServiceInternal;
    private final IUserServiceInternal userServiceInternal;

    @Override
    public void save(SectionRequestDTO sectionRequestDTO,
                     String managerEmail) {
        User user = userServiceInternal.searchByEmail(managerEmail);
        Warehouse warehouse = user.getWarehouse();

        if (sectionRequestDTO.getIdSection() == null) {
            throw new ApiException("Bad Request", "El ID de la sección no puede ser nulo", 400);
        }
        List<Section> allSections = sectionRepository.findAllByWarehouseId(warehouse.getId());

        boolean exist = allSections.stream().anyMatch(
                s -> s.getId().equals(sectionRequestDTO.getIdSection())
        );

        if (exist) {
            throw new ApiException("Bad Request", "La seccion con id "
                    + sectionRequestDTO.getIdSection() + " ya existe.", 400);
        }

        Category category = categoryServiceInternal.findCategoryById(sectionRequestDTO.getIdCategory());

        Section section = new Section(sectionRequestDTO.getIdSection(),
                warehouse,
                category,
                sectionRequestDTO.getMaxBatchCapacity());
        sectionRepository.save(section);
    }

    public List<SectionResponseDTO> getAll(String managerEmail){
        User user = userServiceInternal.searchByEmail(managerEmail);
        Warehouse warehouse = user.getWarehouse();

        List<Section> sectionList = sectionRepository.findAllByWarehouseId(warehouse.getId());

        if (sectionList.isEmpty()) {
            throw new ApiException("Not Found", "No se encontró secciones", 404);
        }
        return sectionList
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    private SectionResponseDTO mapToDTO(Section section) {
        SectionResponseDTO dto = new SectionResponseDTO();
        dto.setIdSection(section.getId());
        dto.setNameWarehouse(section.getWarehouse().getName());
        dto.setNameCategory(section.getCategory().getName());
        dto.setMaxBatchCapacity(section.getMaxBatchCapacity());
        return dto;
    }

}
