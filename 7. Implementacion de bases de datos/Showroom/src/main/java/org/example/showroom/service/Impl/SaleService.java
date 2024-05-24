package org.example.showroom.service.Impl;

import org.example.showroom.exceptions.NotFoundException;
import org.example.showroom.models.Clothes;
import org.example.showroom.models.DTO.ClothesRequestDTO;
import org.example.showroom.models.DTO.ClothesResponseDTO;
import org.example.showroom.models.DTO.SaleRequestDTO;
import org.example.showroom.models.DTO.SaleResponseDTO;
import org.example.showroom.models.Sale;
import org.example.showroom.repository.ISaleRepository;
import org.example.showroom.service.IInternalClotheSaleService;
import org.example.showroom.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService {
    private final String NOT_FOUND_MESSAGE= "the sale with the number provided does not exist";

    private final ModelMapper mapper;

    private final ISaleRepository saleRepository;

    private final IInternalClotheSaleService internalClotheSaleService;

    public SaleService(ISaleRepository saleRepository, IInternalClotheSaleService internalClotheSaleService) {
        this.saleRepository=saleRepository;
        this.internalClotheSaleService=internalClotheSaleService;
        this.mapper=new ModelMapper();
    }

    @Override
    public SaleResponseDTO createNewSale(SaleRequestDTO newSale) {
        Sale sale = convertDTOtoModel(newSale);
        List<Long> clothesIds = newSale.getIdClothes();
        List<Clothes> clothesList = clothesIds.stream()
                .map(internalClotheSaleService::foundByCode)
                .toList();
        sale.setClothes(clothesList);
        sale = saleRepository.save(sale);
        return convertModelToDTO(sale);
    }

    @Override
    public List<SaleResponseDTO> findAllSales() {
        return saleRepository.findAll()
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    @Override
    public SaleResponseDTO findSaleByNumber(Long number) {
        return convertModelToDTO(foundByNumber(number));
    }

    private Sale foundByNumber(Long number){
        return saleRepository.findById(number).orElseThrow(()->
                new NotFoundException(NOT_FOUND_MESSAGE));
    }

    private Sale convertDTOtoModel(SaleRequestDTO sale){
        return mapper.map(sale,Sale.class);
    }
    private SaleResponseDTO convertModelToDTO(Sale sale){
        return mapper.map(sale,SaleResponseDTO.class);
    }


}
