package com.showroom.showroom.service;

import com.showroom.showroom.dto.ClothRequestDTO;
import com.showroom.showroom.dto.ClothResponseDTO;
import com.showroom.showroom.dto.SaleRequestDTO;
import com.showroom.showroom.dto.SaleResponseDto;
import com.showroom.showroom.model.Sale;
import com.showroom.showroom.model.SaleDetail;
import com.showroom.showroom.repository.ClothRepository;
import com.showroom.showroom.repository.SaleDetailRepository;
import com.showroom.showroom.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    ClothRepository clothRepository;

    @Override
    @Transactional
    public SaleResponseDto save(SaleRequestDTO sale) {
        Sale s = mapSale(sale);
        s = salesRepository.save(s);


        createSaleDetails(sale, s);

        return mapSaleResponseDTO(s);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleResponseDto> getAll() {
        return salesRepository.findAll().stream().map(this::mapSaleResponseDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SaleResponseDto getById(Long id) {
        return mapSaleResponseDTO(salesRepository.findSaleById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public SaleResponseDto getByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate localDate = LocalDate.parse(date, formatter);
            return mapSaleResponseDTO(salesRepository.findSaleByDate(localDate));
        } catch (DateTimeParseException e) {
            System.out.println("No se pudo parsear la fecha: " + e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothResponseDTO> getClothes(Long id) {
        List<SaleDetail> clothes = saleDetailRepository.findBySaleId(id);
        return clothes.stream().map(cloth -> ClothResponseDTO.builder()
                .name(cloth.getCloth().getName())
                .type(cloth.getCloth().getType())
                .brand(cloth.getCloth().getBrand())
                .color(cloth.getCloth().getColor())
                .size(cloth.getCloth().getSize())
                .sellPrice(cloth.getCloth().getPrice())
                .build()).toList();
    }

    @Override
    @Transactional
    public SaleResponseDto update(Long id, SaleRequestDTO sale) {
        Sale s = salesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));

        s.setDate(sale.getDate());
        s.setPaymentMethod(sale.getPaymentMethod());

        // Delete existing sale details
        List<SaleDetail> existingSaleDetails = saleDetailRepository.findBySaleId(id);
        saleDetailRepository.deleteAll(existingSaleDetails);

        createSaleDetails(sale, s);

        salesRepository.save(s);

        return mapSaleResponseDTO(s);
    }

    private void createSaleDetails(SaleRequestDTO sale, Sale s) {
        for (ClothRequestDTO clothRequestDTO : sale.getClothes()) {
            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setSale(s);
            saleDetail.setCloth(clothRepository.findClothById(clothRequestDTO.getIdCloth()));
            saleDetail.setQuantity(clothRequestDTO.getQuantity());
            saleDetail.setPrice(clothRepository.findClothById(clothRequestDTO.getIdCloth()).getPrice());

            saleDetailRepository.save(saleDetail);
        }

        calculateTotalPrice(s);
    }

    @Override
    @Transactional
    public String delete(Long id) {
        List<SaleDetail> saleDetails = saleDetailRepository.findBySaleId(id);
        for (SaleDetail saleDetail : saleDetails) {
            saleDetailRepository.delete(saleDetail);
        }

        salesRepository.deleteById(id);
        return "Deleted sale with id: " + id;
    }


    private SaleResponseDto mapSaleResponseDTO(Sale sale) {
        return SaleResponseDto.builder()
                .date(sale.getDate())
                .paymentMethod(sale.getPaymentMethod())
                .totalPrice(sale.getTotalPrice())
                .build();
    }

    private Sale mapSale(SaleRequestDTO sale) {
        Sale s = new Sale();
        s.setDate(sale.getDate());
        s.setPaymentMethod(sale.getPaymentMethod());
        return s;
    }

    private void calculateTotalPrice(Sale sale) {
        double totalPrice = saleDetailRepository.findBySaleId(sale.getId()).stream()
                .mapToDouble(saleDetail -> saleDetail.getPrice() * saleDetail.getQuantity())
                .sum();
        sale.setTotalPrice(totalPrice);
        salesRepository.save(sale);
    }
}
