package com.implementaciondb.ejercicio10_showroom;

import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import com.implementaciondb.ejercicio10_showroom.model.entity.Sale;
import com.implementaciondb.ejercicio10_showroom.model.entity.SaleDetail;
import com.implementaciondb.ejercicio10_showroom.repository.IGarmentRepository;
import com.implementaciondb.ejercicio10_showroom.repository.ISaleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private IGarmentRepository garmentRepository;

    @PostConstruct
    public void init() {
        if (saleRepository.count() == 0) {
            List<Garment> garments = getGarments();
            garmentRepository.saveAll(garments);
            List<Sale> sales = generateSales();
            saleRepository.saveAll(sales);
        }
    }

    public List<Sale> generateSales() {
        List<Garment> garments = getGarments();

        List<SaleDetail> saleDetails1 = Arrays.asList(
                new SaleDetail(1L, 2, 19.99, garments.get(0)),
                new SaleDetail(2L, 1, 49.99, garments.get(1))
        );

        List<SaleDetail> saleDetails2 = Arrays.asList(
                new SaleDetail(3L, 3, 29.99, garments.get(2)),
                new SaleDetail(4L, 2, 24.99, garments.get(3)),
                new SaleDetail(5L, 1, 59.99, garments.get(4))
        );

        List<SaleDetail> saleDetails3 = Arrays.asList(
                new SaleDetail(6L, 1, 89.99, garments.get(5)),
                new SaleDetail(7L, 2, 69.99, garments.get(6))
        );

        List<SaleDetail> saleDetails4 = Arrays.asList(
                new SaleDetail(8L, 4, 9.99, garments.get(8)),
                new SaleDetail(9L, 1, 15.99, garments.get(7)),
                new SaleDetail(10L, 1, 19.99, garments.get(9)),
                new SaleDetail(11L, 3, 29.99, garments.get(10))
        );

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1L, LocalDate.of(2024, 5, 1), calculateTotal(saleDetails1), "Credit Card", saleDetails1));
        sales.add(new Sale(2L, LocalDate.of(2024, 5, 5), calculateTotal(saleDetails2), "Cash", saleDetails2));
        sales.add(new Sale(3L, LocalDate.of(2024, 5, 10), calculateTotal(saleDetails3), "Debit Card", saleDetails3));
        sales.add(new Sale(4L, LocalDate.of(2024, 5, 15), calculateTotal(saleDetails4), "Credit Card", saleDetails4));

        return sales;
    }

    private List<Garment> getGarments() {
        List<Garment> garments = new ArrayList<>();
        garments.add(new Garment(1L, "Camiseta básica", "Camiseta", "Marca A", "Blanco", 42, 100, 19.99));
        garments.add(new Garment(2L, "Pantalón de mezclilla", "Pantalón", "Marca B", "Azul", 32, 50, 49.99));
        garments.add(new Garment(3L, "Sudadera con capucha", "Sudadera", "Marca C", "Negro", 40, 70, 29.99));
        garments.add(new Garment(4L, "Falda corta", "Falda", "Marca D", "Rojo", 36, 40, 24.99));
        garments.add(new Garment(5L, "Vestido largo", "Vestido", "Marca E", "Verde", 38, 30, 59.99));
        garments.add(new Garment(6L, "Chaqueta de cuero", "Chaqueta", "Marca F", "Negro", 44, 20, 89.99));
        garments.add(new Garment(7L, "Zapatos deportivos", "Zapatos", "Marca G", "Blanco", 41, 60, 69.99));
        garments.add(new Garment(8L, "Sombrero de ala ancha", "Sombrero", "Marca H", "Marrón", 56, 15, 15.99));
        garments.add(new Garment(9L, "Bufanda de lana", "Bufanda", "Marca I", "Gris", 180, 25, 9.99));
        garments.add(new Garment(10L, "Guantes de cuero", "Guantes", "Marca J", "Negro", 9, 35, 19.99));
        garments.add(new Garment(11L, "Cinturón de cuero", "Cinturón", "Marca K", "Negro", 95, 45, 29.99));
        garments.add(new Garment(12L, "Pantalones cortos", "Pantalón corto", "Marca L", "Azul", 34, 80, 19.99));
        garments.add(new Garment(13L, "Jersey de punto", "Jersey", "Marca M", "Beige", 40, 25, 39.99));
        garments.add(new Garment(14L, "Camisa formal", "Camisa", "Marca N", "Blanco", 42, 55, 49.99));
        garments.add(new Garment(15L, "Chaleco de vestir", "Chaleco", "Marca O", "Gris", 48, 20, 34.99));
        garments.add(new Garment(16L, "Bañador", "Bañador", "Marca P", "Azul", 40, 50, 24.99));
        garments.add(new Garment(17L, "Calcetines de algodón", "Calcetines", "Marca Q", "Blanco", 43, 200, 5.99));
        garments.add(new Garment(18L, "Pijama de invierno", "Pijama", "Marca R", "Rojo", 38, 30, 29.99));
        garments.add(new Garment(19L, "Chándal", "Chándal", "Marca S", "Gris", 42, 40, 39.99));
        garments.add(new Garment(20L, "Gorra de béisbol", "Gorra", "Marca T", "Azul", 57, 50, 14.99));
        return garments;
    }

    private static Double calculateTotal(List<SaleDetail> saleDetails) {
        return saleDetails.stream().mapToDouble(detail -> detail.getQuantity() * detail.getPrice()).sum();
    }

}
