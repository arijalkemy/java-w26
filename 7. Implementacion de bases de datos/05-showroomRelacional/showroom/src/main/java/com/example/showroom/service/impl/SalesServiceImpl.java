package com.example.showroom.service.impl;

import com.example.showroom.dto.request.SaleRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.SaleDTO;
import com.example.showroom.entity.Cloth;
import com.example.showroom.entity.Sale;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.repository.IClothesRepository;
import com.example.showroom.repository.ISalesRepository;
import com.example.showroom.service.ISalesService;
import com.example.showroom.util.ShowroomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.showroom.util.ShowroomUtil.*;


@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements ISalesService {
    private final ISalesRepository salesRepository;
    private final IClothesRepository clothesRepository;
    private final MessageDTO message = new MessageDTO();


    @Override
    public MessageDTO addNewSale(SaleRequestDTO saleRequestDTO) {
        Sale newSale = saleRequestDTOToSale(saleRequestDTO);
        salesRepository.save(newSale);
        message.setMessage("Sale added successfully with number: " + newSale.getNumber());
        return message;
    }

    @Override
    public void deleteSale(Long number) {
        Sale sale = salesRepository.findById(number)
                .orElseThrow(() -> new NotFoundException("Sale not found."));

        salesRepository.delete(sale);
    }

    @Override
    public List<SaleDTO> getSales() {
        List<Sale> sales = salesRepository.findAll();

        return getSalesDTO(sales);
    }

    @Override
    public List<SaleDTO> getSalesByDate(LocalDate date) {
        List<Sale> sales = salesRepository.findAll();
        List<Sale> salesByDate = sales.stream()
                .filter(s -> s.getDate().equals(date))
                .collect(Collectors.toList());
        return getSalesDTO(salesByDate);
    }

    @Override
    public List<ClothDTO> searchClothesOfSale(Long saleNumber) {
        Sale sale = salesRepository.findById(saleNumber)
                .orElseThrow(() -> new NotFoundException("Sale not found."));

        List<Cloth> clothes = clothesRepository.findBySales(sale);

        return ShowroomUtil.getClothesDTO(clothes);
    }

    @Override
    public SaleDTO showSaleByNumber(Long number) {
        Sale sale = salesRepository.findById(number)
                .orElseThrow(() -> new NotFoundException("There is no sale with that id."));

        return saleToSaleDto(sale);
    }

}
