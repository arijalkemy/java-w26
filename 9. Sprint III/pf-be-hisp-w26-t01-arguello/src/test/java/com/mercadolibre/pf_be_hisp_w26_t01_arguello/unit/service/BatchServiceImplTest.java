package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.SectionDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.enums.BatchOrderType;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockDTO;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.BatchServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IUserServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.util.BatchMapper;
import jnr.constants.platform.Local;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils.TestUtil;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import java.util.*;


import static com.mercadolibre.pf_be_hisp_w26_t01_arguello.enums.BatchOrderType.C;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchServiceImplTest {

    @Mock
    IBatchRepository batchRepository;
    @Mock
    IUserServiceInternal userServiceInternal;
    @Mock
    IProductServiceInternal productServiceInternal;
    @Spy
    @InjectMocks
    BatchServiceImpl batchService;

    @Test
    void countBatchesBySection_Ok() {

        when(batchRepository.countBatchesBySection(anyInt())).thenReturn(5);

        //act
        Integer result = batchService.countBatchesBySection(1);

        //Asserts
        Assertions.assertEquals(5, result);
    }
    @Test
    void addBatchesList_Ok() {
        Batch b = createBatch(1);

        when(batchRepository.findById(1)).thenReturn(Optional.empty());

        when(batchRepository.save(b)).thenReturn(b);

        //act
        List<BatchStockDTO> result = batchService.addBatchesList(List.of(b));

        //Assertions
        Assertions.assertEquals(1, result.size());


    }

    @Test
    void addBatchesListBatchExist_BadRequest() {
        Batch b = createBatch(1);

        when(batchRepository.findById(1)).thenReturn(Optional.of(b));

        //Assertions
        Assertions.assertThrows(ApiException.class, () -> batchService.addBatchesList(List.of(b)));


    }

    @Test
    void addOrUpdateBatchesList_Ok() {
        Batch b = createBatch(1);


        when(batchRepository.save(b)).thenReturn(b);

        //act
        List<BatchStockDTO> result = batchService.addOrUpdateBatchesList(List.of(b));

        //Assertions
        Assertions.assertEquals(b.getId(), result.get(0).getBatch_number());
    }

    @Test
    void getEntityById_Ok(){
        Batch b = createBatch(1);

        when(batchRepository.findById(anyInt())).thenReturn(Optional.of(b));

        //act
        Batch result = batchService.getEntityById(1);

        Assertions.assertEquals(1,result.getId());
    }

    @Test
    void getEntityById_NotFound(){
        Batch b = createBatch(1);

        when(batchRepository.findById(anyInt())).thenReturn(Optional.empty());

        Assertions.assertThrows(ApiException.class, () -> batchService.getEntityById(anyInt()));
    }

    @Test
    void DeleteBatchList_Ok() {
        Batch b = createBatch(1);

        when(batchRepository.findById(anyInt())).thenReturn(Optional.of(b));

        //act
        Boolean deleted = batchService.DeleteBatchList(List.of(b));

        //Assertions
        Assertions.assertEquals(true,deleted);
    }



    @Test
    void DeleteBatchList_NotFound() {
        //Arrange
        Batch b = createBatch(1);
        when(batchRepository.findById(anyInt())).thenReturn(Optional.empty());

        //Assertions
        Assertions.assertThrows(ApiException.class, () -> batchService.DeleteBatchList(List.of(b)));
    }

    @Test
    void getEntityByIdOrNull_Ok(){
        Batch b = createBatch(1);

        when(batchRepository.findById(anyInt())).thenReturn(Optional.of(b));

        //act
        Batch result = batchService.getEntityByIdOrNull(anyInt());

        Assertions.assertEquals(1,result.getId());
    }

    @Test
    void getEntityByIdOrNull_Null(){
        Batch b = createBatch(1);

        when(batchRepository.findById(anyInt())).thenReturn(Optional.empty());

        //act
        Batch result = batchService.getEntityByIdOrNull(anyInt());

        Assertions.assertNull(result);
    }

    @Test
    void getBatchesCloseToExpiration_OK(){
        Batch b = createBatch(1);
        b.setDueDate(LocalDate.of(2024, 2, 15));

        int cantDays =50;
        when(batchRepository.findByDueDateBetween(any(LocalDate.class),any(LocalDate.class))).thenReturn(List.of(b));

        //act
        BatchStockResponseDTO result = batchService.getBatchesCloseToExpiration(cantDays,
                null, null);

        //Asserts
        Assertions.assertEquals(15,result.getBatch_stock().get(0).getDue_date().getDayOfMonth());
        Assertions.assertEquals(2024,result.getBatch_stock().get(0).getDue_date().getYear());
        Assertions.assertEquals(2,result.getBatch_stock().get(0).getDue_date().getMonth().getValue());

    }

    @Test
    void getBatchesCloseToExpiration_NotFound(){
        //arrange
        int cantDays =50;
        when(batchRepository.findByDueDateBetween(any(LocalDate.class),any(LocalDate.class))).thenReturn(List.of());

        //Asserts
        Assertions.assertThrows(ApiException.class, () -> batchService.getBatchesCloseToExpiration(
                cantDays, null, null));

    }

    private Batch createBatch(int batchId) {
        Batch b = new Batch();
        b.setId(batchId);
        b.setProduct(new Product(1, "pan", 200.0, new Category(1, "food", "pan")));

        return b;
    }
    @Test
    public void getProductLocation_Ok() {
        Warehouse warehouseA = new Warehouse(1, "Warehouse A", "Salta", "Salta", null);
        Role adminRole = new Role(1, "Admin", "Administrador");
        User juanUser = new User(1, "juan", null, adminRole,"juangmail.com", warehouseA );
        Category frescoCategory = new Category(1, "Fresco", "Producto fresco");
        Product bananaProduct = new Product(1, "Banana", 1500.0, frescoCategory);
        BatchOrderType batchOrderType = BatchOrderType.C;
        Section section1 = new Section(1, warehouseA, frescoCategory, 100);
        InboundOrder inboundOrder1 = new InboundOrder(1, LocalDate.of(2022,10,05), section1, null);
        List<Batch> batchList = List.of(new Batch(1, bananaProduct, inboundOrder1, 25.0,
                20.0, 100, 70, null, null,
                LocalDate.of(2025,04,01)));

        when(userServiceInternal.searchByEmail(juanUser.getEmail())).thenReturn(juanUser);
        when(productServiceInternal.findById(bananaProduct.getId())).thenReturn(bananaProduct);
        doReturn(batchList).when(batchService).findNonExpiredByProductIdAndWarehouseId(bananaProduct.getId(),
                warehouseA.getId(),
                batchOrderType);

        ProductLocationDTO expected = new ProductLocationDTO(new SectionDTO(1,1),
                1, List.of(new BatchLocationDTO(
                1,70,LocalDate.of(2025,04,01))));

        // Act
        ProductLocationDTO obtained =
                batchService.getProductLocation(juanUser.getEmail(), bananaProduct.getId(), batchOrderType);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findAllByProductIdTest(){
        Integer productId= 1;
        List<Batch> batchListExpected=TestUtil.getBatchList();

        when(batchRepository.findAllByProductId(productId)).thenReturn(TestUtil.getBatchList());

        List<Batch> batchListResult= batchService.findAllByProductId(productId);

        Assertions.assertTrue(CollectionUtils.isEqualCollection(batchListExpected,batchListResult));

    }

    @Test
    public void findAllByProductIdTestSadPath(){
        Integer productId= 1;
        List<Batch> batchListExpected=new ArrayList<>();

        when(batchRepository.findAllByProductId(productId)).thenReturn(batchListExpected);

        Assertions.assertThrows(ApiException.class,()-> batchService.findAllByProductId(productId) );

    }

    @Test
    public void findAllByProductIdAndQuantityGreatherThanCeroTest(){
        Integer productId= 1;
        List<Batch> batchListExpected=TestUtil.getBatchList();

        when(batchRepository.findAllByProductId(productId)).thenReturn(batchListExpected);

        List<Batch> batchListResult= batchService.findAllByProductIdAndQuantityGreatherThanCero(productId);

        Assertions.assertTrue(CollectionUtils.isEqualCollection(batchListExpected,batchListResult));
    }


    @Test
    public void findAllByProductIdAndQuantityGreatherThanCeroTestSadpath(){
        Integer productId= 1;
        List<Batch> batchListExpected=TestUtil.getBatchList();

        when(batchRepository.findAllByProductId(productId)).thenReturn(TestUtil.getBatchListNoStock());

        Assertions.assertThrows(ApiException.class,()-> batchService.findAllByProductIdAndQuantityGreatherThanCero(productId) );
    }



    @Test
    public void findNonExpiredByProductIdAndWarehouseId_Ok_Unordered() {
        List<Batch> batchList = List.of(new Batch(1, null, null, 25.0,
                20.0, 100, 70, null, null,
                LocalDate.now().plusMonths(2)));
        doReturn(batchList).when(batchService).findAllByProductIdAndWarehouseId(1,1);

        List<Batch> obtained = batchService
                .findNonExpiredByProductIdAndWarehouseId(1,1,null);

        Assertions.assertEquals(batchList, obtained);
    }

    @Test
    public void findNonExpiredByProductIdAndWarehouseId_Ok_OrderedByBatchNumber() {
        List<Batch> batchList = createUnorderedBatchList();
        BatchOrderType batchOrderType = BatchOrderType.L;
        doReturn(batchList).when(batchService).findAllByProductIdAndWarehouseId(1,1);
        List<Batch> expected = createOrderedBatchList();

        List<Batch> obtained = batchService
                .findNonExpiredByProductIdAndWarehouseId(1,1, batchOrderType);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findNonExpiredByProductIdAndWarehouseId_Ok_OrderedByQuantity() {
        List<Batch> batchList = createUnorderedBatchList();
        BatchOrderType batchOrderType = C;
        doReturn(batchList).when(batchService).findAllByProductIdAndWarehouseId(1,1);
        List<Batch> expected = createOrderedBatchList();

        List<Batch> obtained = batchService
                .findNonExpiredByProductIdAndWarehouseId(1,1, batchOrderType);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findNonExpiredByProductIdAndWarehouseId_Ok_OrderedByDueDate() {
        List<Batch> batchList = createUnorderedBatchList();
        BatchOrderType batchOrderType = BatchOrderType.F;
        doReturn(batchList).when(batchService).findAllByProductIdAndWarehouseId(1,1);
        List<Batch> expected = createOrderedBatchList();

        List<Batch> obtained = batchService
                .findNonExpiredByProductIdAndWarehouseId(1,1, batchOrderType);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findNonExpiredByProductIdAndWarehouseId_NotFound() {
        List<Batch> emptyBatchList = List.of();
        doReturn(emptyBatchList).when(batchService).findAllByProductIdAndWarehouseId(1,1);

        Assertions.assertThrows(ApiException.class, () -> batchService
                .findNonExpiredByProductIdAndWarehouseId(1, 1, null));
    }

    @Test
    public void findAllByProductIdAndWarehouseId_Ok() {
        List<Batch> expected = List.of(new Batch(1, null, null, 25.0,
                        20.0, 100, 70, null,
                        null, LocalDate.now()));
        when(batchRepository.findAllByProductIdAndWarehouseId(1, 1)).thenReturn(expected);

        List<Batch> obtained = batchService.findAllByProductIdAndWarehouseId(1,1);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findAllByProductIdAndWarehouseId_NotFound() {
        List<Batch> batchList = List.of();
        when(batchRepository.findAllByProductIdAndWarehouseId(1, 1)).thenReturn(batchList);

        Assertions.assertThrows(ApiException.class,
                () -> batchService.findAllByProductIdAndWarehouseId(1,1));
    }

    private List<Batch> createOrderedBatchList(){
        Batch batch1 = new Batch(1, null, null, 25.0,
                20.0, 100, 70, null, null,
                LocalDate.now().plusMonths(4));
        Batch batch2 = new Batch(2, null, null, 25.0,
                20.0, 100, 80, null, null,
                LocalDate.now().plusMonths(5));
        List<Batch> orderedBatchList = List.of(batch1, batch2);
        return orderedBatchList;
    }

    private List<Batch> createUnorderedBatchList(){
        Batch batch1 = new Batch(1, null, null, 25.0,
                20.0, 100, 70, null, null,
                LocalDate.now().plusMonths(4));
        Batch batch2 = new Batch(2, null, null, 25.0,
                20.0, 100, 80, null, null,
                LocalDate.now().plusMonths(5));
        List<Batch> unorderedBatchList = List.of(batch2, batch1);
        return unorderedBatchList;
    }

    @Test
    void checkBatchStockAndNotFoundProducts(){
        List<ProductPurchaseDTO> productPurchaseDTOS = List.of(new ProductPurchaseDTO(1,5));
        Mockito.when(batchRepository.findByProductIdIn(List.of(1))).thenReturn(List.of());
        Assertions.assertThrows(ApiException.class,() -> batchService.checkProductStock(productPurchaseDTOS));
    }

    @Test
    void checkBatchStockAndCalculateCorrectly(){
        List<ProductPurchaseDTO> productPurchaseDTOS = List.of(new ProductPurchaseDTO(1,5));
        Double expectedTotalPrice = 5.0D;
        Mockito.when(batchRepository.findByProductIdIn(List.of(1)))
                .thenReturn(
                        List.of(
                                Batch.builder()
                                        .product(ProductBuilder.getProduct())
                                        .currentQuantity(20)
                                        .build()));

        Assertions.assertEquals(expectedTotalPrice,batchService.checkProductStock(productPurchaseDTOS));
    }

    @Test
    void checkBatchStockAndProductStockNoAvailable(){
        List<ProductPurchaseDTO> productPurchaseDTOS = List.of(new ProductPurchaseDTO(1,5));
        Mockito.when(batchRepository.findByProductIdIn(List.of(1)))
                .thenReturn(
                        List.of(
                                Batch.builder()
                                        .product(ProductBuilder.getProduct())
                                        .currentQuantity(3)
                                        .build()));
        Assertions.assertThrows(ApiException.class,() -> batchService.checkProductStock(productPurchaseDTOS));
    }

    @Test
    public void getBatchesCloseToExpiration_error_args(){

        Assertions.assertThrows(ApiException.class,()->
                batchService.getBatchesCloseToExpiration(1,null, OrderTypeEnum.date_asc));
    }

    @Test
    void getBatchesCloseToExpirationOrderAsc_Ok(){

        int cantExpected = 1;

        Category categoryFrescos = new Category();
        categoryFrescos.setName("fresco");
        Category categoryCongelados = new Category();
        categoryCongelados.setName("congelado");

        Product productFresco = new Product();
        productFresco.setCategory(categoryFrescos);

        Product productCongelado = new Product();
        productCongelado.setCategory(categoryCongelados);

        Batch batch1 = new Batch();
        batch1.setId(1);
        batch1.setProduct(productFresco);

        Batch batch2 = new Batch();
        batch2.setId(2);
        batch2.setProduct(productCongelado);

        int cantDays =3;

        when(batchRepository.findByDueDateBetweenOrderByDueDateAsc(any(LocalDate.class),any(LocalDate.class)))
                .thenReturn(List.of(batch1, batch2));

        //act
        BatchStockResponseDTO result = batchService.getBatchesCloseToExpiration(cantDays,
                CategoryEnum.FS, OrderTypeEnum.date_asc);

        //Asserts

       Assertions.assertEquals(cantExpected, result.getBatch_stock().size());

    }

    @Test
    void getBatchesCloseToExpirationOrderDesc_Ok(){

        int cantExpected = 1;

        Category categoryFrescos = new Category();
        categoryFrescos.setName("fresco");
        Category categoryCongelados = new Category();
        categoryCongelados.setName("congelado");

        Product productFresco = new Product();
        productFresco.setCategory(categoryFrescos);

        Product productCongelado = new Product();
        productCongelado.setCategory(categoryCongelados);

        Batch batch1 = new Batch();
        batch1.setId(1);
        batch1.setProduct(productFresco);

        Batch batch2 = new Batch();
        batch2.setId(2);
        batch2.setProduct(productCongelado);

        int cantDays =3;

        when(batchRepository.findByDueDateBetweenOrderByDueDateDesc(any(LocalDate.class),any(LocalDate.class)))
                .thenReturn(List.of(batch1, batch2));

        //act
        BatchStockResponseDTO result = batchService.getBatchesCloseToExpiration(cantDays,
                CategoryEnum.FS, OrderTypeEnum.date_desc);

        //Asserts

        Assertions.assertEquals(cantExpected, result.getBatch_stock().size());

    }


}
