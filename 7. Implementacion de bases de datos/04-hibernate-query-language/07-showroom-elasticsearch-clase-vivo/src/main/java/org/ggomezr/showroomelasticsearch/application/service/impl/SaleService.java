package org.ggomezr.showroomelasticsearch.application.service.impl;

import org.ggomezr.showroomelasticsearch.application.service.interfaces.ISaleService;
import org.ggomezr.showroomelasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.showroomelasticsearch.domain.dto.SaleDTO;
import org.ggomezr.showroomelasticsearch.domain.exception.NotFoundException;
import org.ggomezr.showroomelasticsearch.domain.model.Sale;
import org.ggomezr.showroomelasticsearch.domain.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        List<Sale> savedSaleList = (List<Sale>) saleRepository.saveAll(saleList);
        return savedSaleList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<SaleDTO> getAllSales() {
        Iterable<Sale> saleList = saleRepository.findAll();
        Stream<Sale> saleStream = StreamSupport.stream(saleList.spliterator(), false);
        return saleStream
                .map(this::convertToDto).toList();
    }

    @Override
    public SaleDTO getSaleById(String code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        return convertToDto(existingSale.get());
    }

    @Override
    public SaleDTO updateSale(SaleDTO saleDTO, String code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        Sale sale = convertToEntity(saleDTO);
        sale.setCode(code);

        Sale updatedSale = saleRepository.save(sale);
        return convertToDto(updatedSale);
    }

    @Override
    public ResponseDTO deleteSale(String code) {
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
    public SaleDTO getSaleByCode(String code) {
        Optional<Sale> existingSale = saleRepository.findById(code);
        if(existingSale.isEmpty()) throw new NotFoundException("Sale not found");

        return convertToDto(existingSale.get());
    }

    private Sale convertToEntity(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }

    private SaleDTO convertToDto(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }
}
