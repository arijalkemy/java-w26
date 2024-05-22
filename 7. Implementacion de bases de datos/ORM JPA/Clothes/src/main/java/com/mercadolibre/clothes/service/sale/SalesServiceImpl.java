package com.mercadolibre.clothes.service.sale;

import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.dto.sale.SaleRequestDTO;
import com.mercadolibre.clothes.dto.sale.SaleResponseDTO;
import com.mercadolibre.clothes.exception.ClothNotFoundException;
import com.mercadolibre.clothes.exception.DateConversionException;
import com.mercadolibre.clothes.exception.SaleNotFoundException;
import com.mercadolibre.clothes.model.Cloth;
import com.mercadolibre.clothes.model.Sale;
import com.mercadolibre.clothes.repository.IClothesRepository;
import com.mercadolibre.clothes.repository.ISalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements ISalesService {
    private final ISalesRepository salesRepository;
    private final IClothesRepository clothesRepository;

    public SalesServiceImpl(ISalesRepository salesRepository, IClothesRepository clothesRepository) {
        this.salesRepository = salesRepository;
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Long createSale(SaleRequestDTO saleRequestDTO) {
        return salesRepository.save(mapDTOtoSale(saleRequestDTO)).getNumber();
    }

    private Sale mapDTOtoSale(SaleRequestDTO saleRequestDTO) {
        Set<Cloth> clothSet = new HashSet<>();
        for (Long code : saleRequestDTO.getClothList()) {
            clothSet.add(findAndCheckClothById(code));
        }

        LocalDate date = getLocalDate(saleRequestDTO.getDate());

        Sale sale = getDTOToSaleModelMapper().map(saleRequestDTO, Sale.class);
        sale.setClothList(clothSet);
        sale.setDate(date);
        return sale;
    }

    private static LocalDate getLocalDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (IllegalArgumentException e) {
            throw new DateConversionException("Invalid date input: " + date);
        }
    }

    @Override
    public List<SaleResponseDTO> getAllSales(String date) {
        List<Sale> sales;
        if (date == null) {
            sales = salesRepository.findAll();
        } else {
            sales = salesRepository.findSalesByDateEquals(getLocalDate(date));
        }
        return sales
                .stream()
                .map(SalesServiceImpl::mapSaleToResponseDTO)
                .toList();
    }

    @Override
    public SaleResponseDTO getSaleById(Long number) {
        return mapSaleToResponseDTO(findAndCheckSale(number));
    }

    @Override
    public SaleResponseDTO updateSale(Long number, SaleRequestDTO saleRequestDTO) {
        findAndCheckSale(number);
        Sale updated = mapDTOtoSale(saleRequestDTO);
        updated.setNumber(number);
        salesRepository.save(updated);
        return mapSaleToResponseDTO(updated);
    }

    @Override
    public void deleteSale(Long number) {
        findAndCheckSale(number);
        salesRepository.deleteById(number);
    }

    @Override
    public Set<ClothResponseDTO> getClothesFromSale(Long number) {
        return findAndCheckSale(number).getClothList()
                .stream().map(cloth -> new ModelMapper().map(cloth, ClothResponseDTO.class))
                .collect(Collectors.toSet());
    }

    private Sale findAndCheckSale(Long number) {
        return salesRepository.findById(number)
                .orElseThrow(() -> new SaleNotFoundException("Sale with number " + number + " was not found"));
    }

    private static SaleResponseDTO mapSaleToResponseDTO(Sale sale) {

        SaleResponseDTO responseDTO = getSaleToDTOModelMapper().map(sale, SaleResponseDTO.class);
        Set<ClothResponseDTO> clothSet = new HashSet<>();
        for (Cloth cloth : sale.getClothList()) {
            clothSet.add(new ModelMapper().map(cloth, ClothResponseDTO.class));
        }
        responseDTO.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(sale.getDate()));
        responseDTO.setClothList(clothSet);
        return responseDTO;
    }

    private static ModelMapper getSaleToDTOModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getTypeMap(Sale.class, SaleResponseDTO.class)
                .addMappings(mapper -> mapper.skip(SaleResponseDTO::setDate))
                .addMappings(mapper -> mapper.skip(SaleResponseDTO::setClothList));
        return modelMapper;
    }

    private static ModelMapper getDTOToSaleModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getTypeMap(SaleRequestDTO.class, Sale.class)
                .addMappings(mapper -> mapper.skip(Sale::setDate))
                .addMappings(mapper -> mapper.skip(Sale::setClothList));
        return modelMapper;
    }

    private Cloth findAndCheckClothById(Long code) {
        return clothesRepository.findById(code)
                .orElseThrow(() -> new ClothNotFoundException("Cloth with id " + code + " not found"));
    }
}
