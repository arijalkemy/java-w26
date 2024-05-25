package com.example.demo.service.saleService;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;
import com.example.demo.model.dto.saleDTO.SaleRequestDTO;
import com.example.demo.model.dto.saleDTO.SaleResponseDTO;
import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Sale;
import com.example.demo.repository.ISaleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    private final ISaleRepository saleRepository;
    private final ObjectMapper objectMapper;

    public SaleServiceImpl(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepository.save(mapToEntity(saleRequestDTO));
        return mapToResposeDto(sale);
    }

    @Override
    public List<SaleResponseDTO> getSales() {
        List<Sale> saleList = saleRepository.findAll();
        List<SaleResponseDTO> saleResponseDTOList = new ArrayList<>();
        for(Sale sale: saleList) {
            mapToResposeDto(sale);
            saleResponseDTOList.add(mapToResposeDto(sale));
        }
        return saleResponseDTOList;
    }

    @Override
    public SaleResponseDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro la venta"));
        return mapToResposeDto(sale);
    }

    @Override
    public SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO) {
        Sale sale = mapToEntity(saleRequestDTO);
        sale.setId(id);
        saleRepository.save(sale);
        return mapToResposeDto(sale);
    }

    @Override
    public String deleteSale(Long id) {
        saleRepository.deleteById(id);
        return "Se elimino con exito";
    }

    @Override
    public List<ClothesResponseDTO> getClothesSoldOnDate(LocalDate date) {
        List<Clothes> salesOnDate = saleRepository.findAllClothesBySaleDate(date);
        return salesOnDate.stream().map(this::mapToClothesResponseDto).toList();
    }

    @Override
    public List<ClothesResponseDTO> getClothesBySale(Long saleId) {
        List<Clothes> clothes = saleRepository.findAllClothesBySale(saleId);
        return clothes.stream().map(this::mapToClothesResponseDto).toList();
    }

    private SaleResponseDTO mapToResposeDto(Sale sale) {
        return objectMapper.convertValue(sale, SaleResponseDTO.class);
    }

    private Sale mapToEntity(SaleRequestDTO sale) {
        return objectMapper.convertValue(sale, Sale.class);
    }

    private ClothesResponseDTO mapToClothesResponseDto(Clothes clothes) {
        return objectMapper.convertValue(clothes, ClothesResponseDTO.class);
    }

}

