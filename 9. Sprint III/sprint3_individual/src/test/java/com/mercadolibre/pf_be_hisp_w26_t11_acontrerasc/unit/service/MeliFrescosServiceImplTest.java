package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos.*;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.exceptions.ApiException;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos.*;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.*;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.PurchaseOrderProduct;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.service.MeliFrescosServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.MockitoAnnotations;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos.BatchSearchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.Section;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.repository.IBatchRepository;
@ExtendWith(MockitoExtension.class)
public class MeliFrescosServiceImplTest {
    @Mock
    IBatchRepository batchRepository;
    @Mock
    IStatusRepository statusRepository;
    @Mock
    IPurchaseOrderProductRepository purchaseOrderProductRepository;
    @Mock
    IUserRepository userRepository;
    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;
    @Mock
    IInboundOrderRepository inboundOrderRepository;

    @Mock
    ISectionRepository sectionRepository;
    @Mock
    IWarehouseRepository warehouseRepository;
    @Mock
    IProductRepository productRepository;


    @InjectMocks
    MeliFrescosServiceImpl meliFrescosService;

    @InjectMocks
    MeliFrescosServiceImpl frescosService;

    ModelMapper mapper;

    List<ProductSimpleResponseDTO> products;

    User user;
    Warehouse warehouse;
    Section section;
    SectionDTO sectionDTO;
    InboundOrderRequestDTO inboundOrderRequestDTO;
    InboundOrderDTO inboundOrderDTO;
    BatchStockRequestDTO batchStockRequestDTO;

    BatchStockResponseDTO batchStockResponseDTO;
    InboundOrderResponseDTO inboundOrderResponseDTO;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        user = new User();
        warehouse = new Warehouse();
        section = new Section();
        sectionDTO = new SectionDTO();
        inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderDTO = new InboundOrderDTO();
        batchStockRequestDTO = new BatchStockRequestDTO();

        // user
        user.setId(1);
        user.setUsername("test");
        user.setPassword("test");
        user.setRole(Role.SELLER);
        user.setFirstName("test");
        user.setLastName("test");

        // warehouse
        warehouse.setId(1);
        warehouse.setRepresentative(user);
        warehouse.setWarehouseCode(2);

        // section
        section.setId(1);
        section.setSectionCode(7);
        section.setWarehouse(warehouse);
        section.setCapacity(100);

        // setionDTO
        sectionDTO.setWarehouseCode(2);
        sectionDTO.setSectionCode(7);

        // batchStockRequestDTO
        batchStockRequestDTO.setProductId(1);
        batchStockRequestDTO.setBatchNumber(2);
        batchStockRequestDTO.setCurrentQuantity(10);
        batchStockRequestDTO.setManufacturingDate(LocalDate.now());
        batchStockRequestDTO.setManufacturingTime(null);
        batchStockRequestDTO.setDueDate(LocalDate.now());
        batchStockRequestDTO.setInitialQuantity(10);
        batchStockRequestDTO.setCurrentTemperature(10.00);
        batchStockRequestDTO.setMinimumTemperature(10.00);

        // inboundOrderDTO
        inboundOrderDTO.setOrderNumber(2);
        inboundOrderDTO.setOrderDate(LocalDate.now());
        inboundOrderDTO.setSection(sectionDTO);
        inboundOrderDTO.setBatchStock(List.of(batchStockRequestDTO));

        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);

        batchStockResponseDTO = BatchStockResponseDTO.builder()
                .productId(1)
                .batchNumber(2)
                .currentQuantity(10)
                .manufacturingDate(LocalDate.now())
                .manufacturingTime(null)
                .dueDate(LocalDate.now())
                .initialQuantity(10)
                .currentTemperature(10.00)
                .minimumTemperature(10.00)
                .build();

        inboundOrderResponseDTO = InboundOrderResponseDTO.builder()
                .batchStock(List.of(batchStockResponseDTO))
                .build();
    }


    @Test
    @DisplayName("Testeando el registro de una orden de compra 200")
    void registerPurchaseOrderCorrect() {
//        Arrange
        PurchaseRequestDTO purchaseRequestDTO;
        User buyer;
        PurchaseOrder purchaseOrder;
        Status status;
        Product product;

        buyer = new User();
        buyer.setId(4);
        buyer.setRole(Role.BUYER);

        status = new Status();
        status.setStatusCode("PENDING");

        product = new Product();
        product.setId(1);
        product.setPrice(10.0);

        PurchasedProductDTO purchasedProductDTO = new PurchasedProductDTO();
        purchasedProductDTO.setProductId(1);
        purchasedProductDTO.setQuantity(2);

        List<PurchasedProductDTO> products = new ArrayList<>();
        products.add(purchasedProductDTO);

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setBuyerId(1);
        purchaseOrderDTO.setDate(LocalDate.now());
        purchaseOrderDTO.setOrderStatus(new StatusDTO("Carrito"));
        purchaseOrderDTO.setProducts(products);

        purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setPurchaseOrder(purchaseOrderDTO);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1);
        purchaseOrder.setBuyer(buyer);
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setStatus(status);

        Batch batch = new Batch();
        batch.setProduct(product);
        batch.setInitialQuantity(1000);
        batch.setCurrentQuantity(950);
        batch.setDueDate(LocalDate.now().plusDays(20));


        when(userRepository.findById(anyInt())).thenReturn(Optional.of(buyer));
        when(purchaseOrderRepository.findByBuyer(any(User.class))).thenReturn(Optional.empty());
        when(statusRepository.findByStatusCode(anyString())).thenReturn(Optional.of(status));
        when(purchaseOrderRepository.save(any(PurchaseOrder.class))).thenReturn(purchaseOrder);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(batchRepository.findAllByProduct(product)).thenReturn(List.of(batch));

        PurchaseResponseDTO response = frescosService.registerPurchaseOrder(purchaseRequestDTO);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(20.0, response.getTotalCost());
    }


    @Test
    @DisplayName("Prueba exitosa con solicitud válida debe retornar lotes")
    public void testListOrderedDueDateProducts_ValidRequest_ShouldReturnBatches() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(10);

        Product product = new Product();
        product.setId(1);

        Section section = new Section();
        ProductType productType = new ProductType(1, "Fresco", "FS", new HashSet<>());
        section.setProductType(productType);

        Batch batch1 = new Batch();
        batch1.setDueDate(currentDate.plusDays(5));
        batch1.setProduct(product);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setDueDate(currentDate.plusDays(7));
        batch2.setProduct(product);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByDueDate(currentDate, futureDate)).thenReturn(batches);

        BatchSearchStockResponseDTO response = meliFrescosService.listOrderedDueDateProducts(10, Optional.empty(), Optional.empty());

        assertEquals(2, response.getBatchStockExtendedDTOList().size());
    }

    @Test
    @DisplayName("Prueba con tipo de producto inválido debe lanzar excepción")
    public void testListOrderedDueDateProducts_InvalidProductType_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            meliFrescosService.listOrderedDueDateProducts(10, Optional.of("INVALID"), Optional.empty());
        });
    }

    @Test
    @DisplayName("Prueba con categoría válida debe retornar lotes filtrados")
    public void testListOrderedDueDateProducts_ValidCategory_ShouldReturnFilteredBatches() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(10);

        Product product = new Product();
        product.setId(1);

        Section section = new Section();
        ProductType productType = new ProductType(1, "frescos", "FS", new HashSet<>());
        section.setProductType(productType);

        Batch batch1 = new Batch();
        batch1.setDueDate(currentDate.plusDays(5));
        batch1.setProduct(product);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setDueDate(currentDate.plusDays(7));
        batch2.setProduct(product);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByDueDateAndProductType(currentDate, futureDate, 1)).thenReturn(batches);

        BatchSearchStockResponseDTO response = meliFrescosService.listOrderedDueDateProducts(10, Optional.of("FS"), Optional.empty());

        assertEquals(2, response.getBatchStockExtendedDTOList().size());
    }

    @Test
    @DisplayName("Prueba con orden válido debe retornar lotes ordenados")
    public void testListOrderedDueDateProducts_ValidOrder_ShouldReturnSortedBatches() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(10);

        Product product = new Product();
        product.setId(1);

        Section section = new Section();
        ProductType productType = new ProductType(1, "frescos", "FS", new HashSet<>());
        section.setProductType(productType);

        Batch batch1 = new Batch();
        batch1.setDueDate(currentDate.plusDays(10));
        batch1.setProduct(product);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setDueDate(currentDate.plusDays(5));
        batch2.setProduct(product);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByDueDate(currentDate, futureDate)).thenReturn(batches);

        BatchSearchStockResponseDTO response = meliFrescosService.listOrderedDueDateProducts(10, Optional.empty(), Optional.of("date_asc"));
        int DateToTest = LocalDate.now().getDayOfMonth() + 10;
        // Verificamos que el primer elemento en la lista esté ordenado por fecha ascendente
        assertEquals(DateToTest, response.getBatchStockExtendedDTOList().get(1).getDueDate().getDayOfMonth());
    }

    @Test
    void listProductStockByWarehouse_productExists() {
        // Arrange
        Integer productId = 1;
        WarehouseDTO warehouseDTO = new WarehouseDTO(1, 100L);
        when(productRepository.existsById(productId)).thenReturn(true);
        when(productRepository.findWarehousesAndQuantitiesByProductId(productId)).thenReturn(Collections.singletonList(warehouseDTO));

        // Act
        ProductWarehouseResponseDTO result = meliFrescosService.listProductStockByWarehouse(productId);

        // Assert
        assertEquals(productId.intValue(), result.getProductId());
        assertFalse(result.getWarehouses().isEmpty());
        assertEquals(warehouseDTO, result.getWarehouses().get(0));
    }
    @Test
    @DisplayName("Testeando el registro de una orden de compra ya existente 400")
    void registerPurchaseOrderIncorrect() {
//        Arrange
        PurchaseRequestDTO purchaseRequestDTO;
        User buyer;
        PurchaseOrder purchaseOrder;
        Status status;
        Product product;

        buyer = new User();
        buyer.setId(4);
        buyer.setRole(Role.BUYER);

        status = new Status();
        status.setStatusCode("PENDING");

        product = new Product();
        product.setId(1);
        product.setPrice(10.0);

        PurchasedProductDTO purchasedProductDTO = new PurchasedProductDTO();
        purchasedProductDTO.setProductId(1);
        purchasedProductDTO.setQuantity(2);

        List<PurchasedProductDTO> products = new ArrayList<>();
        products.add(purchasedProductDTO);

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setBuyerId(1);
        purchaseOrderDTO.setDate(LocalDate.now());
        purchaseOrderDTO.setOrderStatus(new StatusDTO("Carrito"));
        purchaseOrderDTO.setProducts(products);

        purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setPurchaseOrder(purchaseOrderDTO);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1);
        purchaseOrder.setBuyer(buyer);
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setStatus(status);



        when(userRepository.findById(anyInt())).thenReturn(Optional.of(buyer));
        when(purchaseOrderRepository.findByBuyer(any(User.class))).thenReturn(Optional.of(purchaseOrder));


//        Act & Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> frescosService.registerPurchaseOrder(purchaseRequestDTO));
    }

    @Test
    @DisplayName("Testeando la actualizacion de una orden de compra 200")
    void updatePurchaseOrder() {

//        Arrange
        PurchaseRequestDTO purchaseRequestDTO;
        User buyer;
        PurchaseOrder purchaseOrder;
        Status status;
        Product product;

        buyer = new User();
        buyer.setId(4);
        buyer.setRole(Role.BUYER);

        status = new Status();
        status.setStatusCode("PENDING");

        product = new Product();
        product.setId(1);
        product.setPrice(10.0);

        PurchasedProductDTO purchasedProductDTO = new PurchasedProductDTO();
        purchasedProductDTO.setProductId(1);
        purchasedProductDTO.setQuantity(3);

        List<PurchasedProductDTO> products = new ArrayList<>();
        products.add(purchasedProductDTO);

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setBuyerId(1);
        purchaseOrderDTO.setDate(LocalDate.now());
        purchaseOrderDTO.setOrderStatus(new StatusDTO("Carrito"));
        purchaseOrderDTO.setProducts(products);

        purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setPurchaseOrder(purchaseOrderDTO);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1);
        purchaseOrder.setBuyer(buyer);
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setStatus(status);

        Batch batch = new Batch();
        batch.setProduct(product);
        batch.setInitialQuantity(1000);
        batch.setCurrentQuantity(950);
        batch.setDueDate(LocalDate.now().plusDays(20));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(buyer));
        when(purchaseOrderRepository.findByBuyer(any(User.class))).thenReturn(Optional.of(purchaseOrder));
        when(statusRepository.findByStatusCode(anyString())).thenReturn(Optional.of(status));
        when(purchaseOrderRepository.save(any(PurchaseOrder.class))).thenReturn(purchaseOrder);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(batchRepository.findAllByProduct(product)).thenReturn(List.of(batch));


//        Act
        PurchaseResponseDTO response = frescosService.updatePurchaseOrder(purchaseRequestDTO);

//        Assert
        Assertions.assertNotNull(response);
        Assertions.assertEquals(30.0, response.getTotalCost());
    }


    @Test
    void listProductStockByWarehouse_productDoesNotExist() {
        // Arrange
        Integer productId = 1;
        when(productRepository.existsById(productId)).thenReturn(false);

        // Act & Assert
        assertThrows(ApiException.class, () -> meliFrescosService.listProductStockByWarehouse(productId));
    }




    @Test
    @DisplayName("Testeando la actualizacion de una orden de compra No existente 200")
    void updatePurchaseOrderIncorrect() {
//        Arrange
        PurchaseRequestDTO purchaseRequestDTO;
        User buyer;

        buyer = new User();
        buyer.setId(10);
        buyer.setRole(Role.BUYER);

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setBuyerId(buyer.getId());

        purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setPurchaseOrder(purchaseOrderDTO);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(buyer));
        when(purchaseOrderRepository.findByBuyer(any(User.class))).thenReturn(Optional.empty());


//        Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> frescosService.updatePurchaseOrder(purchaseRequestDTO));
    }

    @Test
    void listProductStockByWarehouse_productNotInAnyWarehouse() {
        // Arrange
        Integer productId = 1;
        when(productRepository.existsById(productId)).thenReturn(true);
        when(productRepository.findWarehousesAndQuantitiesByProductId(productId)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(ApiException.class, () -> meliFrescosService.listProductStockByWarehouse(productId));
    }
    @Test
    void listProductsTestWithRequestParam()
    {
        // arrange
        Optional<String> acronym = Optional.of("FS");
        List<ProductSimpleResponseDTO> expectedProducts = List.of(
                new ProductSimpleResponseDTO( "Manzanas", 32.6),
                new ProductSimpleResponseDTO ("Peras", 60D),
                new ProductSimpleResponseDTO("Platanos", 12D)
        );

        // act
        when(productRepository.findAllByProductTypeAcronym(acronym.get())).thenReturn(expectedProducts);
        List<ProductSimpleResponseDTO>  response = frescosService.listProducts(acronym);

        // assert
        assertThat(response).isEqualTo(expectedProducts);
        verify(productRepository).findAllByProductTypeAcronym(acronym.get());
        verifyNoMoreInteractions(productRepository);

    }
    @Test
    void listProductsTestWithOutRequestParam()
    {
        // arrange
        mapper = new ModelMapper();
        Optional<String> acronym = Optional.empty();

        Set<PurchaseOrderProduct> emptyPurchaseOrders = new HashSet<>();
        Set<Batch> emptyBatches = new HashSet<>();

        List<Product> expectedProducts = List.of(
                new Product(1, "Manzanas", 34.67D, emptyPurchaseOrders, emptyBatches),
                new Product(2, "Peras", 60D, emptyPurchaseOrders, emptyBatches),
                new Product(3, "Platanos", 12D, emptyPurchaseOrders, emptyBatches)
        );

        List<ProductSimpleResponseDTO> mappedProducts = expectedProducts.stream()
                .map(product -> mapper.map(product, ProductSimpleResponseDTO.class))
                .toList();

        when(productRepository.findAll()).thenReturn(expectedProducts);

        // act
        List<ProductSimpleResponseDTO> response  = frescosService.listProducts(acronym);

        // arrange
        assertThat(response).isEqualTo(mappedProducts);
    }

    @Test
    void listProductsTestWithRequestParamNoOk()
    {
        // arrange
        Optional<String> acronym = Optional.of("FS");
        List<ProductSimpleResponseDTO> expectedResponse = List.of();
        when(productRepository.findAllByProductTypeAcronym(acronym.get())).thenReturn(expectedResponse);

        // act and assert
        Assertions.assertThrows(NotFoundException.class, () -> frescosService.listProducts(acronym));
    }

    @Test
    void listProductsTestWithOutRequestParamNoOk()
    {
        // arrange
        Optional<String> acronym = Optional.empty();
        List<Product> expectedResponse = List.of();
        when(productRepository.findAll()).thenReturn(expectedResponse);

        // act and assert
        Assertions.assertThrows(NotFoundException.class, () -> frescosService.listProducts(acronym));
    }


    @Test
    void listProductsFromOrderOk()
    {
        // arrange
        Integer orderId = 1;
        List<ProductSimpleResponseDTO> expectedProducts = List.of(
                new ProductSimpleResponseDTO( "Manzanas", 32.6),
                new ProductSimpleResponseDTO ("Peras", 60D),
                new ProductSimpleResponseDTO("Platanos", 12D)
        );
        when(purchaseOrderRepository.findById(orderId)).thenReturn(Optional.of(new PurchaseOrder()));
        when(purchaseOrderProductRepository.findProductsByOrderId(orderId)).thenReturn(expectedProducts);

        // act
        List<ProductSimpleResponseDTO> response = frescosService.listProductsFromOrder(orderId);

        // assert
        assertThat(response).isEqualTo(expectedProducts);
    }

    @Test
    void listProductsFromOrderNoOk()
    {
        // arrange
        Integer orderId = 1;
        when(purchaseOrderRepository.findById(orderId)).thenReturn(Optional.empty());

        // act and assert
        Assertions.assertThrows(NotFoundException.class, () -> frescosService.listProductsFromOrder(orderId));

    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada en el sistema con datos correctos.
     * Configura una lista de BatchStockRequestDTO y la establece en el objeto inboundOrderDTO.
     * Mapea el objeto inboundOrderRequestDTO a un objeto InboundOrder y establece el vendedor en el objeto InboundOrder.
     * Verifica que la orden de entrada no exista en el sistema y que el almacén y la sección existan.
     * Luego, llama al método createInboundOrder del servicio meliFrescosService.
     * Finalmente, verifica que el número de orden de la orden de entrada sea 2 y que el representante del almacén sea el usuario.
     *
     */
    @DisplayName("crear inbound order service ok")
    @Test
    public void createInboundOrderTest() {

        List<BatchStockRequestDTO> batchStockRequestDTOList = List.of(batchStockRequestDTO);
        inboundOrderDTO.setBatchStock(batchStockRequestDTOList);
        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);
        InboundOrder inboundOrder = mapper.map(inboundOrderRequestDTO, InboundOrder.class);
        inboundOrder.setSeller(warehouse.getRepresentative());

        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(null);

        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));

        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.of(section));

        when(productRepository.findById(batchStockRequestDTO.getProductId())).thenReturn(Optional.of(new Product()));

        meliFrescosService.createInboundOrder(inboundOrderRequestDTO);


        verify(inboundOrderRepository, atLeast(1)).save(inboundOrder);
        verify(batchRepository, atLeast(1)).saveAll(any(List.class));


        Assertions.assertEquals(2, inboundOrder.getOrderNumber());
        Assertions.assertEquals(user, warehouse.getRepresentative());

    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada que ya existe en el sistema.
     * Configura el número de orden a 1, que ya existe en el sistema.
     * Luego, llama al método createInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Inbound Order ya existe".
     *
     */
    @DisplayName("crear inbound order error inboundOrderExist")
    @Test
    public void createInboundOrderErrorInboundOrderExistTest() {
        inboundOrderDTO.setOrderNumber(1);
        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);
        InboundOrder inboundOrder = mapper.map(inboundOrderRequestDTO, InboundOrder.class);

        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(inboundOrder);


        try {
            meliFrescosService.createInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Inbound Order ya existe", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada con un almacén que no existe en el sistema.
     * Configura el código del almacén a 100, que no existe en el sistema.
     * Luego, llama al método createInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Warehouse no existe".
     *
     */
    @DisplayName("crear inbound order error warehouse")
    @Test
    public void createInboundOrderErrorWarehouseTest() {
        List<BatchStockRequestDTO> batchStockRequestDTOList = List.of(batchStockRequestDTO);
        sectionDTO.setWarehouseCode(100);
        inboundOrderDTO.setBatchStock(batchStockRequestDTOList);
        inboundOrderDTO.setSection(sectionDTO);
        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);
        InboundOrder inboundOrder = mapper.map(inboundOrderRequestDTO, InboundOrder.class);
        inboundOrder.setSeller(warehouse.getRepresentative());


        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);


        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(null);

        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.empty());

        try {
            meliFrescosService.createInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Warehouse no existe", e.getCode());
        }

    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada con una sección que no existe en el sistema.
     * Configura el código de la sección a 100, que no existe en el sistema.
     * Luego, llama al método createInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Section no existe".
     *
     */
    @DisplayName("crear inbound order error section")
    @Test
    public void createInboundOrderErrorSectionTest() {
        List<BatchStockRequestDTO> batchStockRequestDTOList = List.of(batchStockRequestDTO);
        inboundOrderDTO.setBatchStock(batchStockRequestDTOList);
        sectionDTO.setSectionCode(100);
        inboundOrderDTO.setSection(sectionDTO);
        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);
        InboundOrder inboundOrder = mapper.map(inboundOrderRequestDTO, InboundOrder.class);
        inboundOrder.setSeller(warehouse.getRepresentative());

        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(null);

        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));

        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.empty());


        try {
            meliFrescosService.createInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Section no existe", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada en el sistema con datos correctos.
     * Mapea el objeto inboundOrderRequestDTO a un objeto InboundOrder y el objeto batchStockRequestDTO a un objeto Batch.
     * Configura los objetos mock para devolver los objetos esperados cuando se llaman los métodos correspondientes.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Finalmente, verifica que la respuesta sea igual a inboundOrderResponseDTO.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order con datos correctos")
    public void updateInboundOrderTest() {
        InboundOrder inboundOrder = mapper.map(inboundOrderRequestDTO, InboundOrder.class);
        Batch batch = mapper.map(batchStockRequestDTO, Batch.class);

        // Configurar los objetos mock
        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(inboundOrder);
        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));
        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.of(section));
        when(batchRepository.findByBatchNumber(anyInt())).thenReturn(batch);
        when(batchRepository.findAllBySection(any(Section.class))).thenReturn(List.of(batch));
        when(batchRepository.saveAll(any(List.class))).thenReturn(List.of(batch));

        InboundOrderResponseDTO response = meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);

        Assertions.assertEquals(inboundOrderResponseDTO, response);
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada que no existe en el sistema.
     * Configura el objeto mock para devolver null cuando se llama al método findByOrderNumber del repositorio inboundOrderRepository.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Inbound Order not found".
     *
     * @throws ApiException si el almacén no existe.
     */
    @Test
    @DisplayName("Actualizar inbound que no existe")
    public void updateInboundOrderErrorInboundOrderNotExistTest() {
        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(null);

        try {
            meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Inbound Order not found", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con un almacén que no existe en el sistema.
     * Configura los objetos mock para devolver los objetos esperados cuando se llaman los métodos correspondientes, excepto para el método findById del repositorio warehouseRepository, que devuelve un Optional vacío.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Warehouse not found".
     *
     * @throws ApiException si el almacén no existe.
     */
    @Test
    @DisplayName("Actualizar inbound con warehouse incorrecto")
    public void updateInboundOrderErrorWarehouseTest() {
        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(mapper.map(inboundOrderRequestDTO, InboundOrder.class));
        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.empty());

        try {
            meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Warehouse not found", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con una sección que no existe en el sistema.
     * Configura los objetos mock para devolver los objetos esperados cuando se llaman los métodos correspondientes, excepto para el método findById del repositorio sectionRepository, que devuelve un Optional vacío.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Section not found".
     *
     * @throws ApiException si la sección no existe.
     */
    @Test
    @DisplayName("Actualizar inbound con sección incorrecta")
    public void updateInboundOrderErrorSectionTest() {
        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(mapper.map(inboundOrderRequestDTO, InboundOrder.class));
        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));
        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.empty());

        try {
            meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Section not found", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con un lote que no existe en el sistema.
     * Configura los objetos mock para devolver los objetos esperados cuando se llaman los métodos correspondientes, excepto para el método findByBatchNumber del repositorio batchRepository, que devuelve null.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Batch not found".
     *
     * @throws ApiException si el lote no existe.
     */
    @Test
    @DisplayName("Actualizar inbound con batch incorrecto")
    public void updateInboundOrderErrorBatchTest() {
        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(mapper.map(inboundOrderRequestDTO, InboundOrder.class));
        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));
        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.of(section));
        when(batchRepository.findByBatchNumber(anyInt())).thenReturn(null);

        try {
            meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Batch not found", e.getCode());
        }
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada donde la capacidad de la sección se supera.
     * Configura la cantidad actual del lote a 10000, superando la capacidad de la sección.
     * Configura los objetos mock para devolver los objetos esperados cuando se llaman los métodos correspondientes.
     * Luego, llama al método updateInboundOrder del servicio meliFrescosService.
     * Espera una excepción ApiException con el código "Section capacity exceeded".
     *
     * @throws ApiException si la capacidad de la sección se supera.
     */
    @Test
    @DisplayName("Actualizar inbound order, pero la capacidad de la sección fue superada")
    public void updateInboundOrderErrorSectionCapacityTest() {
        batchStockRequestDTO.setCurrentQuantity(10000);

        when(inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber())).thenReturn(mapper.map(inboundOrderRequestDTO, InboundOrder.class));
        when(warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode())).thenReturn(Optional.of(warehouse));
        when(sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode())).thenReturn(Optional.of(section));
        when(batchRepository.findByBatchNumber(anyInt())).thenReturn(mapper.map(batchStockRequestDTO, Batch.class));
        when(batchRepository.findAllBySection(any(Section.class))).thenReturn(List.of(mapper.map(batchStockRequestDTO, Batch.class)));

        try {
            meliFrescosService.updateInboundOrder(inboundOrderRequestDTO);
        } catch (ApiException e) {
            Assertions.assertEquals("Section capacity exceeded", e.getCode());
        }
    }

    @Test
    @DisplayName("RE 3: Should return product batches successfully")
    public void testListBatchesOfProduct_Success() {
        // Arrange
        Integer productId = 1;
        Product product = new Product();
        product.setId(productId);

        Section section = new Section();
        section.setId(1);
        section.setSectionCode(123);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setWarehouseCode(456);
        section.setWarehouse(warehouse);

        Batch batch1 = new Batch();
        batch1.setBatchNumber(1);
        batch1.setCurrentQuantity(10);
        batch1.setDueDate(LocalDate.now().plusWeeks(4));
        batch1.setSection(section);
        batch1.setProduct(product);

        Batch batch2 = new Batch();
        batch2.setBatchNumber(2);
        batch2.setCurrentQuantity(20);
        batch2.setDueDate(LocalDate.now().plusWeeks(5));
        batch2.setSection(section);
        batch2.setProduct(product);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByMinDueDate(any(LocalDate.class), eq(productId))).thenReturn(batches);
        when(sectionRepository.findById(section.getId())).thenReturn(Optional.of(section));
        when(warehouseRepository.findById(warehouse.getId())).thenReturn(Optional.of(warehouse));

        // Act
        ProductBatchesResponseDTO response = meliFrescosService.listBatchesOfProduct(productId, Optional.empty());

        // Assert
        assertNotNull(response);
        assertEquals(productId.intValue(), response.getProductId());
        assertEquals(2, response.getBatches().size());
        assertEquals(123, response.getSection().getSectionCode());
        assertEquals(456, response.getSection().getWarehouseCode());
    }

    @Test
    @DisplayName("RE 3: Should throw exception when product not found")
    public void testListBatchesOfProduct_ProductNotFound() {
        // Arrange
        Integer productId = 1;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () -> {
            meliFrescosService.listBatchesOfProduct(productId, Optional.empty());
        });

        assertEquals("product_not_found", exception.getMessage());
    }

    @Test
    @DisplayName("RE 3: Should throw exception when no batches found")
    public void testListBatchesOfProduct_NoBatchesFound() {
        // Arrange
        Integer productId = 1;
        Product product = new Product();
        product.setId(productId);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByMinDueDate(any(LocalDate.class), eq(productId))).thenReturn(Collections.emptyList());

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () -> {
            meliFrescosService.listBatchesOfProduct(productId, Optional.empty());
        });

        assertEquals("batches_not_found", exception.getMessage());
    }

    @Test
    @DisplayName("RE 3: Should throw exception when product appears in single batch")
    public void testListBatchesOfProduct_SingleBatch() {
        // Arrange
        Integer productId = 1;
        Product product = new Product();
        product.setId(productId);

        Section section = new Section();
        section.setId(1);
        section.setSectionCode(123);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setWarehouseCode(456);
        section.setWarehouse(warehouse);

        Batch batch1 = new Batch();
        batch1.setBatchNumber(1);
        batch1.setCurrentQuantity(10);
        batch1.setDueDate(LocalDate.now().plusWeeks(4));
        batch1.setSection(section);
        batch1.setProduct(product);



        List<Batch> batches = Collections.singletonList(batch1);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findByMinDueDate(any(LocalDate.class), eq(productId))).thenReturn(batches);

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () -> {
            meliFrescosService.listBatchesOfProduct(productId, Optional.empty());
        });

        assertEquals("product_in_single_batch", exception.getMessage());
    }
    @Test
    void verifyProductCreation()
    {
        // arrange
        ProductRequestDto productRequestDto = new ProductRequestDto(1, "Cocacola", 28.8);

        Set<PurchaseOrderProduct> emptyPurchaseOrders = new HashSet<>();
        Set<Batch> emptyBatches = new HashSet<>();
        Product expectedProduct = new Product(1, "Cocacola", 28.8, emptyPurchaseOrders, emptyBatches);
        ProductStatusDto expectedResult = new ProductStatusDto("Product created successfully", 201);

        when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);

        // act
        ProductStatusDto result = meliFrescosService.createProduct(productRequestDto);

        // assert
        assertEquals(expectedResult, result);
    }
    @Test
    void verifyNotFoundExceptionOnUpdateProduct()
    {
        // arrange
        Integer productId = 1;
        ProductRequestDto productRequestDto = new ProductRequestDto(1, "Cocacola", 28.8);

        // act and assert
        when(productRepository.existsById(productId)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> meliFrescosService.updateProduct(productRequestDto));
    }
    @Test
    void verifyBadRequestExceptionWhenIdFieldIsEmpty()
    {
        // arrange
        ProductRequestDto productRequestDto = new ProductRequestDto("Cocacola", 28.8);

        // act and assert
        assertThrows(BadRequestException.class, () -> meliFrescosService.updateProduct(productRequestDto));
    }
    @Test
    void verifySuccessUpdateProduct()
    {
        // arrange
        Integer productId = 1;
        ProductRequestDto productRequestDto = new ProductRequestDto(1, "Cocacola", 28.8);
        Product product = new Product();
        product.setId(productId);
        ProductStatusDto expectedResult = new ProductStatusDto("Product updated successfully", 200);
        // act and assert
        when(productRepository.existsById(productId)).thenReturn(true);
        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductStatusDto result = meliFrescosService.updateProduct(productRequestDto);
        assertDoesNotThrow(() -> meliFrescosService.updateProduct(productRequestDto));
        assertEquals(expectedResult, result);
    }

    @Test
    void verifyNotFoundExceptionOnGetProductsByBatches()
    {
        // arrange
        // act
        when(productRepository.findExtendDataOfProductById()).thenReturn(List.of());
        assertThrows(NotFoundException.class, () -> meliFrescosService.getProductsBatches());
    }
}
