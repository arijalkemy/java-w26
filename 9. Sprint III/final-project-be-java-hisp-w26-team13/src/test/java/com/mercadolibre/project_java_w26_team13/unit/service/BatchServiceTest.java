package com.mercadolibre.project_java_w26_team13.unit.service;

import com.mercadolibre.project_java_w26_team13.dtos.*;
import com.mercadolibre.project_java_w26_team13.entity.*;
import com.mercadolibre.project_java_w26_team13.exceptions.ApiException;
import com.mercadolibre.project_java_w26_team13.repository.IBatchRepository;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import com.mercadolibre.project_java_w26_team13.service.BatchService;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTest {

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private JWTClaims jwtClaims;

    @InjectMocks
    private BatchService batchService;

    @Test
    public void searchBatchesByProductTest() {
        // Arrange
        Long productId = 1L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 2013, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setBatchNumber("B001");
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByProduct(product)).thenReturn(batches);

        // Act
        BatchesByProductDTO got = batchService.searchBatchesByProduct(productId, null,"authorizationHeader");

        // Assert
        assertEquals(expectedResponse.getProductId(), got.getProductId());
        assertEquals(expectedResponse.getBatchStock().get(0).getBatchNumber(), got.getBatchStock().get(0).getBatchNumber());
        assertEquals(expectedResponse.getBatchStock().size(), got.getBatchStock().size());
        assertEquals(expectedResponse.getSection().getId(), expectedResponse.getSection().getId());
    }

    @Test
    public void searchBatchesByProductOrderedByBatchTest() {
        // Arrange
        Long productId = 1L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 1, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setBatchNumber("B001");
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        Batch batch2 = new Batch();
        batch2.setId(2L);
        batch2.setBatchNumber("B002");
        batch2.setCurrentQuantity(80);
        batch2.setDueDate(LocalDate.of(2024, 8, 9));
        batch2.setOrder(order);
        Batch batch3 = new Batch();
        batch3.setId(3L);
        batch3.setBatchNumber("B003");
        batch3.setCurrentQuantity(60);
        batch3.setDueDate(LocalDate.of(2024, 8, 8));
        batch3.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        batches.add(batch2);
        batches.add(batch3);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        batchStock.add(new MinimumBatchDTO("B002", 80, LocalDate.of(2024, 8, 9)));
        batchStock.add(new MinimumBatchDTO("B003", 60, LocalDate.of(2024, 8, 8)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByProduct(product)).thenReturn(batches);

        // Act
        BatchesByProductDTO got = batchService.searchBatchesByProduct(productId, "L","authorizationHeader");

        // Assert
        assertEquals(expectedResponse.getProductId(), got.getProductId());
        assertEquals(expectedResponse.getBatchStock().get(0).getBatchNumber(), got.getBatchStock().get(0).getBatchNumber());
        assertEquals(expectedResponse.getBatchStock().size(), got.getBatchStock().size());
        assertEquals(expectedResponse.getBatchStock(), got.getBatchStock());
        assertEquals(expectedResponse.getSection().getId(), expectedResponse.getSection().getId());
    }

    @Test
    public void searchBatchesByProductOrderedByQuantityTest() {
        // Arrange
        Long productId = 1L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 1, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setBatchNumber("B001");
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        Batch batch2 = new Batch();
        batch2.setId(2L);
        batch2.setBatchNumber("B002");
        batch2.setCurrentQuantity(80);
        batch2.setDueDate(LocalDate.of(2024, 8, 9));
        batch2.setOrder(order);
        Batch batch3 = new Batch();
        batch3.setId(3L);
        batch3.setBatchNumber("B003");
        batch3.setCurrentQuantity(60);
        batch3.setDueDate(LocalDate.of(2024, 8, 8));
        batch3.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        batches.add(batch2);
        batches.add(batch3);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        batchStock.add(new MinimumBatchDTO("B002", 80, LocalDate.of(2024, 8, 9)));
        batchStock.add(new MinimumBatchDTO("B003", 60, LocalDate.of(2024, 8, 8)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByProduct(product)).thenReturn(batches);

        // Act
        BatchesByProductDTO got = batchService.searchBatchesByProduct(productId, "L","authorizationHeader");

        // Assert
        assertEquals(expectedResponse.getProductId(), got.getProductId());
        assertEquals(expectedResponse.getBatchStock().get(0).getBatchNumber(), got.getBatchStock().get(0).getBatchNumber());
        assertEquals(expectedResponse.getBatchStock().size(), got.getBatchStock().size());
        assertEquals(expectedResponse.getBatchStock(), got.getBatchStock());
        assertEquals(expectedResponse.getSection().getId(), expectedResponse.getSection().getId());
    }

    @Test
    public void searchBatchesByProductOrderedByDateTest() {
        // Arrange
        Long productId = 1L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 1, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setBatchNumber("B001");
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        Batch batch2 = new Batch();
        batch2.setId(2L);
        batch2.setBatchNumber("B002");
        batch2.setCurrentQuantity(80);
        batch2.setDueDate(LocalDate.of(2024, 8, 9));
        batch2.setOrder(order);
        Batch batch3 = new Batch();
        batch3.setId(3L);
        batch3.setBatchNumber("B003");
        batch3.setCurrentQuantity(60);
        batch3.setDueDate(LocalDate.of(2024, 8, 8));
        batch3.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        batches.add(batch2);
        batches.add(batch3);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        batchStock.add(new MinimumBatchDTO("B002", 80, LocalDate.of(2024, 8, 9)));
        batchStock.add(new MinimumBatchDTO("B003", 60, LocalDate.of(2024, 8, 8)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByProduct(product)).thenReturn(batches);

        // Act
        BatchesByProductDTO got = batchService.searchBatchesByProduct(productId, "L","authorizationHeader");

        // Assert
        assertEquals(expectedResponse.getProductId(), got.getProductId());
        assertEquals(expectedResponse.getBatchStock().get(0).getBatchNumber(), got.getBatchStock().get(0).getBatchNumber());
        assertEquals(expectedResponse.getBatchStock().size(), got.getBatchStock().size());
        assertEquals(expectedResponse.getBatchStock(), got.getBatchStock());
        assertEquals(expectedResponse.getSection().getId(), expectedResponse.getSection().getId());
    }

    @Test
    public void searchBatchesByProductInvalidOrderParameterTest() {
        // Arrange
        Long productId = 1L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 1, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByProduct(product)).thenReturn(batches);

        // Act
        String expectedExceptionMessage = "Invalid order parameter.";

        // Assert
        ApiException thrownException = assertThrows(ApiException.class, () -> batchService.searchBatchesByProduct(productId, "order","authorizationHeader"));
        assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }

    @Test
    public void searchBatchesByProductNotFoundTest() {
        // Arrange
        Long productId = 113412L;

        // Mock Product
        Product product = new Product();
        product.setId(productId);
        product.setName("Producto A");

        // Mock Order & Section
        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(new Warehouse(1L, "W001", 2013, List.of(section)));
        section.setName("Congelados");
        Order order = new Order(1L, 1, LocalDate.of(2023, 8, 10), section, new ArrayList<>());

        // Mock Batch
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024, 8, 10));
        batch.setOrder(order);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        order.setBatchs(batches);


        // Mock SectionDTO
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(1L);
        sectionDTO.setWarehouse_id(1L);

        // Mock BatchesByProductDTO
        BatchesByProductDTO expectedResponse = new BatchesByProductDTO();
        expectedResponse.setSection(sectionDTO);
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100, LocalDate.of(2024, 8, 10)));
        expectedResponse.setBatchStock(batchStock);
        expectedResponse.setProductId(productId);

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());

        // Mock Repository
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act
        String expectedExceptionMessage = "Batch list for product with id " + productId + " not found.";

        // Assert
        ApiException thrownException = assertThrows(ApiException.class, () -> batchService.searchBatchesByProduct(productId, null,"authorizationHeader"));
        assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }

    @Test
    public void getProductStockByWarehouse(){
        Long productId = 113412L;

        Product product = new Product(productId, "Producto 1", 10.0);

        Order order1 = new Order(1L, 1001, LocalDate.now(), null, null);
        Order order2 = new Order(2L, 1002, LocalDate.now(), null, null);
        Order order3 = new Order(3L, 1003, LocalDate.now(), null, null);

        Section section1 = new Section(1L, "", null);
        Section section2 = new Section(2L, "", null);
        Section section3 = new Section(3L, "", null);

        Warehouse warehouse1 = new Warehouse(1L, "", 2013, null);
        Warehouse warehouse3 = new Warehouse(3l, "", 2024, null);

        section1.setWarehouse(warehouse1);
        section2.setWarehouse(warehouse1);
        section3.setWarehouse(warehouse3);

        order1.setSection(section1);
        order2.setSection(section2);
        order3.setSection(section3);

        Batch batch1 = new Batch(1L, product, "B001", 25.0, 20.0, 100, 50, LocalDate.now(), LocalTime.now(), LocalDate.now(), order1);
        Batch batch2 = new Batch(2L, product, "B002", 30.0, 25.0, 150, 50, LocalDate.now(), LocalTime.now(),LocalDate.now(), order2);
        Batch batch3 = new Batch(3L, product, "B003", 20.0, 15.0, 80, 100, LocalDate.now(), LocalTime.now(), LocalDate.now(), order3);

        order1.setBatchs(List.of(batch1));
        order2.setBatchs(List.of(batch2));
        order3.setBatchs(List.of(batch3));

        List<Batch> batches = List.of(batch1, batch2, batch3);

        String auth = "authorizationHeader";

        List<WarehouseProductDto> warehouseProductDtoList = List.of(new WarehouseProductDto(2024, 100),
                                                                    new WarehouseProductDto(2013, 100));

        ProductStockDto expected = new ProductStockDto(productId, warehouseProductDtoList);
        Mockito.doNothing().when(jwtClaims).validateHeader(auth, Roles.REPRESENTANTE.getRole());
        when(batchRepository.findAllByProductId(productId)).thenReturn(batches);

        Assertions.assertEquals(expected, batchService.getProductStockByWarehouse(productId, auth));
    }


    @Test
    public void getProductStockByWarehouseEmptyBatchList(){
        Long productId = 113412L;
        String message = "Batch list for product with id " + productId + " not found.";

        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.REPRESENTANTE.getRole());
        when(batchRepository.findAllByProductId(productId)).thenReturn(new ArrayList<>());

        Assertions.assertThrows(ApiException.class,
                () -> batchService.getProductStockByWarehouse(productId, "authorizationHeader"),
                message);
    }
}
