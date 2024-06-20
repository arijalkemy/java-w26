package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.service;


import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.BatchServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.utils.BatchGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BatchServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private ISectorRepository sectorRepository;

    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    BatchServiceImpl service;

    @Test
    @DisplayName("Test US0001 - A new batch with its respective inbound order is successfully created.")
    public void uploadBatch() {
        //Arrange
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchRequest();
        BatchResponseDto batchObtenido;
        BatchResponseDto batchEsperado = BatchGenerator.getBatchResponse();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);

        Product myProduct = new Product();
        Category category = new Category();

        category.setId(1);
        myProduct.setCategory(category);
        mySector.setCategory(category);

        Optional<Product> posibleProducto = Optional.of(myProduct);

        Warehouse myWarehouse = new Warehouse();
        Optional<Warehouse> posibleWarehouse = Optional.of(myWarehouse);
        //Act
        when(sectorRepository.findById(1)).thenReturn(posibleSector);

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            Integer idProduct =  b.getProduct_id();
            when(productRepository.findById(idProduct)).thenReturn(posibleProducto);

        }

        Integer warehouseCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getWarehouseCode();
        when(warehouseRepository.findById(warehouseCode)).thenReturn(posibleWarehouse);

        //Assert
        batchObtenido = service.uploadBatchIntoStock(uploadBatchRequestDto);
        Assertions.assertEquals(batchEsperado, batchObtenido);
    }

    @Test
    @DisplayName("Test US001 SAD PATH - Not Found Exception thrown beacuase of not sector id exist ")
    public void sectorIdNotFound() {
        UploadBatchRequestDto uploadBatchRequestDto = new UploadBatchRequestDto();
        InboundOrderDto inboundOrderDto = new InboundOrderDto();
        SectionDto sectionDto = new SectionDto();

        sectionDto.setSectionCode(2);
        inboundOrderDto.setSectionDto(sectionDto);
        uploadBatchRequestDto.setInboundOrderDto(inboundOrderDto);

        when(sectorRepository.findById(anyInt())).thenReturn(Optional.empty());

        //System.out.println(service.uploadBatchIntoStock(uploadBatchRequestDto).toString());
        Assertions.assertThrows(NotFoundException.class, () -> service.uploadBatchIntoStock(uploadBatchRequestDto));
    }

    @Test
    @DisplayName("Test US001 SAD PATH - Not Found Exception thrown beacuase of not product id exist ")
    public void productIdNotFound() {
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchRequest();
        Integer sectionCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getSectionCode();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);

        when(sectorRepository.findById(sectionCode)).thenReturn(posibleSector);


        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {

            when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        }

        Assertions.assertThrows(NotFoundException.class, () -> service.uploadBatchIntoStock(uploadBatchRequestDto));
    }

    @Test
    @DisplayName("Test US0001 - The product and sector does not match ")
    public void productAndSectorNotEquals() {
        //Arrange
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchRequest();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);

        Product myProduct = new Product();
        Category category = new Category();
        Category anotherCategory = new Category();

        category.setId(1);
        anotherCategory.setId(2);
        myProduct.setCategory(category);
        mySector.setCategory(anotherCategory);

        Optional<Product> posibleProducto = Optional.of(myProduct);

        Warehouse myWarehouse = new Warehouse();
        Optional<Warehouse> posibleWarehouse = Optional.of(myWarehouse);
        //Act
        when(sectorRepository.findById(1)).thenReturn(posibleSector);

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            Integer idProduct =  b.getProduct_id();
            when(productRepository.findById(idProduct)).thenReturn(posibleProducto);

        }

        Assertions.assertThrows(NotFoundException.class, () -> service.uploadBatchIntoStock(uploadBatchRequestDto));

    }

    @Test
    @DisplayName("Test US0001 - Not Found Exception thrown beacuase of not warehouse id exist ")
    public void warehouseNotFound() {
        //Arrange
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchRequest();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);

        Product myProduct = new Product();
        Category category = new Category();

        category.setId(1);
        myProduct.setCategory(category);
        mySector.setCategory(category);

        Optional<Product> posibleProducto = Optional.of(myProduct);

        //Act
        when(sectorRepository.findById(1)).thenReturn(posibleSector);

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            Integer idProduct =  b.getProduct_id();
            when(productRepository.findById(idProduct)).thenReturn(posibleProducto);

        }

        when(warehouseRepository.findById(anyInt())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> service.uploadBatchIntoStock(uploadBatchRequestDto));

    }

    @Test
    @DisplayName("Test US0001 - Se actualiza de manera existosa el batch ")
    public void updateBatch() {

        //arrange
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchUpdated();
        BatchResponseDto batchObtained;
        BatchResponseDto batchEsperado = BatchGenerator.getBatchResponseUpdated();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);

        Product myProduct = new Product();

        Optional<Product> posibleProducto = Optional.of(myProduct);

        Batch myBatch = new Batch();
        //Act
        Integer sectionCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getSectionCode();
        when(sectorRepository.findById(sectionCode)).thenReturn(posibleSector);

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {

            when(batchRepository.findBatchByBatchNumber(b.getBatchNumber())).thenReturn(myBatch);

            when(productRepository.findById(b.getProduct_id())).thenReturn(posibleProducto);
        }
        //Arrange

        batchObtained = service.updateBatchInStock(uploadBatchRequestDto);
        Assertions.assertEquals(batchObtained, batchEsperado);


    }

    @Test
    @DisplayName("Test US0001 - Not Found Exception thrown beacuase the batch does not exist")
    public void batchNotFound() {
        //arrange
        UploadBatchRequestDto uploadBatchRequestDto = BatchGenerator.getBatchUpdated();

        Sector mySector = new Sector();
        mySector.setId(1);
        Optional<Sector> posibleSector = Optional.of(mySector);
        //Act
        Integer sectionCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getSectionCode();
        when(sectorRepository.findById(sectionCode)).thenReturn(posibleSector);

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {

            when(batchRepository.findBatchByBatchNumber(anyInt())).thenReturn(null);

        }

        Assertions.assertThrows(NotFoundException.class, () -> service.updateBatchInStock(uploadBatchRequestDto));
    }



}
