package com.mercadolibre.final_project_java_h_w26_t10.service.implementations;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Category;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Sector;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Warehouse;
import com.mercadolibre.final_project_java_h_w26_t10.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_h_w26_t10.repository.ISectorRepository;
import com.mercadolibre.final_project_java_h_w26_t10.service.ISectorService;
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
