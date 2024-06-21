package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.BatchResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IUserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTest {

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    BatchServiceImpl batchService;

    private final ObjectMapper om;

    public BatchServiceTest() {
        this.om = new ObjectMapper();
        this.om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.om.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("mostrar los batch por vencer en los ultimos 3 dias")
    public void getBatchesByDueDateTest() {
        //Arrange
        LocalDate dueDate = LocalDate.now().plusDays(3);
        ProductType productType = new ProductType();
        productType.setId(1L);
        Product product = new Product();
        product.setId(1L);
        product.setProductType(productType);
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setProduct(product);
        batch.setDueDate(dueDate);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        when(batchRepository.findByDueDateBetweenOrderByDueDateAsc(LocalDate.now(), dueDate)).thenReturn(batches);
        List<BatchResponseDto> expected = batches.stream()
                .map(b -> {
                    BatchResponseDto batchDto = new BatchResponseDto();
                    batchDto = om.convertValue(b, BatchResponseDto.class);
                    batchDto.setProductId(b.getProduct().getId().intValue());
                    batchDto.setProductTypeId(b.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();

        //Act
        List<BatchResponseDto> result = batchService.getBatchesByDueDate(3);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("batch por categoria en orden asc de los ultimos 3 dias")
    public void getBatchListByCategoryOrderByDueDateAscTest() {
        //Arrange
        LocalDate dueDate = LocalDate.now().plusDays(3);
        ProductType productType = new ProductType();
        productType.setId(1L);
        Product product = new Product();
        product.setId(1L);
        product.setProductType(productType);
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setProduct(product);
        batch.setDueDate(dueDate);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        when(batchRepository
                .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateAsc(LocalDate.now(), dueDate, ProductTypeEnum.FRESCO))
                .thenReturn(batches);

        List<BatchResponseDto> expected = batches.stream()
                .map(b -> {
                    BatchResponseDto batchDto = new BatchResponseDto();
                    batchDto = om.convertValue(b, BatchResponseDto.class);
                    batchDto.setProductId(b.getProduct().getId().intValue());
                    batchDto.setProductTypeId(b.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();

        //Act
        List<BatchResponseDto> result = batchService.getBatchListByCategoryOrderByDueDate(3, "FS", "date_asc");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("batch por categoria en orden desc de los ultimos 3 dias")
    public void getBatchListByCategoryOrderByDueDateDescTest() {
        //Arrange
        LocalDate dueDate = LocalDate.now().plusDays(3);
        ProductType productType = new ProductType();
        productType.setId(1L);
        Product product = new Product();
        product.setId(1L);
        product.setProductType(productType);
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setProduct(product);
        batch.setDueDate(dueDate);
        List<Batch> batches = new ArrayList<>();
        batches.add(batch);
        when(batchRepository
                .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateDesc(LocalDate.now(), dueDate, ProductTypeEnum.FRESCO))
                .thenReturn(batches);

        List<BatchResponseDto> expected = batches.stream()
                .map(b -> {
                    BatchResponseDto batchDto = new BatchResponseDto();
                    batchDto = om.convertValue(b, BatchResponseDto.class);
                    batchDto.setProductId(b.getProduct().getId().intValue());
                    batchDto.setProductTypeId(b.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();

        //Act
        List<BatchResponseDto> result = batchService.getBatchListByCategoryOrderByDueDate(3, "FS", "date_desc");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Conversión de String a Enum - FRESCO")
    public void getProductTypeEnumFrescoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testGetEnum("FS", ProductTypeEnum.FRESCO);
    }

    @Test
    @DisplayName("Conversión de String a Enum - REFRIGERADO")
    public void getProductTypeEnumRefrigeradoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testGetEnum("RF", ProductTypeEnum.REFRIGERADO);
    }

    @Test
    @DisplayName("Conversión de String a Enum - CONGELADO")
    public void getProductTypeEnumCongeladoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testGetEnum("FF", ProductTypeEnum.CONGELADO);
    }

    @Test
    @DisplayName("Conversión de String a Enum - Ninguno de los Enum")
    public void getEnumNoMatchTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testGetEnum("OTRO", null);
    }

    private void testGetEnum(String productType, ProductTypeEnum expectedEnum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        BatchServiceImpl batchService = new BatchServiceImpl(om, batchRepository);
        Method method = BatchServiceImpl.class.getDeclaredMethod("getEnum", String.class);
        method.setAccessible(true);

        // Act
        ProductTypeEnum result = (ProductTypeEnum) method.invoke(batchService, productType);

        // Assert
        Assertions.assertEquals(expectedEnum, result);
    }
}
