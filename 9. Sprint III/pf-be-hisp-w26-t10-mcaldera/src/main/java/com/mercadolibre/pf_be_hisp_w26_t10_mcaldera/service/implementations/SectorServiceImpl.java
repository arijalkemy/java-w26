package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.ISectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorServiceImpl implements ISectorService {

    @Autowired
    private ISectorRepository sectorRepository;

    public Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse) {
        Optional<Sector> sector = sectorRepository.findByCategoryAndWarehouse(category,warehouse);
        if (sector.isPresent()) {
            if (!sector.get().getBatches().isEmpty()){
                return sector.get();
            }else{
                throw new NotFoundException("Not found batches on sector");
            }
        }else {
            throw new NotFoundException("Sector not found");
        }
    }

}
