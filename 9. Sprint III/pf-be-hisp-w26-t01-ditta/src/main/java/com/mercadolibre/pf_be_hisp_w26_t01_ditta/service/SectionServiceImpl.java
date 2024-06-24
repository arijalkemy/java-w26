package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.ISectionRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ISectionServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements ISectionServiceInternal {
    private final ISectionRepository sectionRepository;
    private final IBatchService batchService;
    @Override
    public Section searchById(Integer id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new ApiException("Not Found","No se encontró un sector con id: " + id, 404));
    }
    @Override
    public Section searchByIdAndWarehouseId(Integer id, Integer warehouseId ) {
        Section section = searchById(id);
        if (!section.getWarehouse().getId().equals(warehouseId)) {
            throw new ApiException(
                    "Bad Request",
                    String.format("El sector con id %s no corresponde al warehouse con id %s", id, warehouseId),
                    400
            );
        }
        return section;
    }
    @Override
    public Section searchAndValidateByWarehouseAndQuantity (int idSection, int idWarehouse, int newBatches){
        Section section = searchByIdAndWarehouseId(idSection, idWarehouse);
        hasSpace(section, newBatches);
        return section;
    }

    private boolean hasSpace(Section section, Integer newBatches){
        int numOfBatches = batchService.countBatchesBySection(section.getId()) + newBatches;
        if (numOfBatches > section.getMaxBatchCapacity())
        {
            throw  new ApiException("Bad Request","No hay espacio disponible en la seccion para cargar estos lotes",400);
        }
        return true;
    }
}
