package org.ggomezr.showroommysql.application.service.impl;

import org.ggomezr.showroommysql.application.service.interfaces.ISaleService;
import org.ggomezr.showroommysql.domain.dto.ResponseDTO;
import org.ggomezr.showroommysql.domain.dto.SaleDTO;
import org.ggomezr.showroommysql.domain.exception.NotFoundException;
import org.ggomezr.showroommysql.domain.model.Sale;
import org.ggomezr.showroommysql.domain.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;
    private final ModelMapper modelMapper;

    public SaleService(ISaleRepository saleRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = convertToEntity(saleDTO);
        Sale savedSale = saleRepository.save(sale);
        return convertToDto(savedSale);
    }

    @Override
    public List<SaleDTO> createSalesBatch(List<SaleDTO> saleDTOList) {
        List<Sale> saleList = saleDTOList.stream()
                .map(this::convertToEntity).toList();
        List<Sale> savedSaleList = saleRepository.saveAll(saleList);
        return savedSaleList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<SaleDTO> getAllSales() {
        List<Sale> saleList = saleRepository.findAll();
        return saleList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public SaleDTO getSaleById(Long code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        return convertToDto(existingSale.get());
    }

    @Override
    public SaleDTO updateSale(SaleDTO saleDTO, Long code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        Sale sale = convertToEntity(saleDTO);
        sale.setCode(code);

        Sale updatedSale = saleRepository.save(sale);
        return convertToDto(updatedSale);
    }

    @Override
    public ResponseDTO deleteSale(Long code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        saleRepository.deleteById(code);
        return new ResponseDTO("Sale deleted successfully");
    }

    @Override
    public List<SaleDTO> getSalesByDate(LocalDate date) {
        List<Sale> saleList = saleRepository.findByDate(date);
        return saleList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<SaleDTO> getSaleByCode(Long code) {
        List<Sale> saleList = saleRepository.findByCode(code);
        return saleList.stream()
                .map(this::convertToDto).toList();
    }

    private Sale convertToEntity(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }

    private SaleDTO convertToDto(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }
}
