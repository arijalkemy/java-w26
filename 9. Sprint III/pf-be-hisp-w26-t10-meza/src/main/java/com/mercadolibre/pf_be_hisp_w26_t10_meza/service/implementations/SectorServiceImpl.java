package com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.ISectorService;
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
