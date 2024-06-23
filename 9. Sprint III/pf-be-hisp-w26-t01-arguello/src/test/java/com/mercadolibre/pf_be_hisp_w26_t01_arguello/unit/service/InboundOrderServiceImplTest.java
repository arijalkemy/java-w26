package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.service;


import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.IInboundOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.InboundOrderServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.util.InboundOrderMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InboundOrderServiceImplTest {


    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @Mock
    private IWarehouseServiceInternal warehouseService;

    @Mock
    private ISectionServiceInternal sectionServiceInternal;

    @Mock
    private IProductServiceInternal productServiceInternal;

    @Mock
    private IBatchService batchService;

    @Mock IBatchServiceInternal batchServiceInternal;

    @InjectMocks
    private InboundOrderServiceImpl inboundOrdenService;


    @Test
    public void testCrearOrdenEntranteValidaYCreacionDeLotes_Ok() throws Exception {
        // Preparación
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = prepareInboundOrderDto(1);

        //genero usuario que va a ser representante
        User user = new User();
        user.setEmail("jgual@gmail.com");
        //genero warehouse y asigno representante
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setCity("Cordoba");
        warehouse.setManager(user);

        //mock de warehouse
        when(warehouseService.findWarehouseById(anyInt())).thenReturn(warehouse);

        //genero categoria y seccion para mockear
        Category category = new Category();
        category.setId(1);
        Section section = new Section();
        section.setId(1);
        section.setCategory(category);
        section.setWarehouse(warehouse);
        section.setMaxBatchCapacity(1000);

        //mockeo seccion
        when(sectionServiceInternal.searchAndValidateByWarehouseAndQuantity(anyInt(),anyInt(),anyInt())).thenReturn(section);

        //creo producto para mockear
        Product product = new Product();
        product.setCategory(category);
        product.setId(50);
        product.setName("Cartas");
        product.setPrice(200.0);
        //mockeo producto
        when(productServiceInternal.findById(anyInt())).thenReturn(product);


        //creo orden con la request y la seccion
        InboundOrder inboundOrder = InboundOrderMapper.InboundOrderRequestDtoToInboundOrder(request, section);

        //mockeo el guardado de la orden
        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(inboundOrder);

        //mockeo el guardado de los lotes
        when(batchService.addBatchesList(anyList())).thenReturn(request.getBatchStock());


        // Ejecución
        BatchStockResponseDTO result = inboundOrdenService.create(request, emailUser);

        // Aserciones y verificaciones
        assertNotNull(result);
        verify(inboundOrderRepository).save(any(InboundOrder.class));
        verify(batchService).addBatchesList(anyList());
        assertEquals(50,result.getBatch_stock().get(0).getProduct_id());
        assertEquals(2,result.getBatch_stock().size());
    }

    @Test
    void CreateWhenOrderNumberExists_BadRequest(){
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = new InboundOrderDto();
        request.setOrderNumber(1);
        request.setOrderDate(LocalDate.of(2023, 3, 15));
        SectionDTO sectionDto = new SectionDTO();
        sectionDto.setSection_code(1);
        sectionDto.setWarehouse_code(1);
        request.setSection(sectionDto);
        List<BatchStockDTO> listaStock = Arrays.asList(
                new BatchStockDTO(1,50,5.0,2.0,150,
                        145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15))

        );
        request.setBatchStock(listaStock);


        when(inboundOrderRepository.existsById(anyInt())).thenReturn(true);


        //Assert
        Assertions.assertThrows(ApiException.class, () ->  inboundOrdenService.create(request, emailUser));

    }

    @Test
    void CreateWhenProductIdDoesntExists_BadRequest() {
        // Preparación
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = new InboundOrderDto();
        request.setOrderNumber(1);
        request.setOrderDate(LocalDate.of(2023, 3, 15));
        SectionDTO sectionDto = new SectionDTO();
        sectionDto.setSection_code(1);
        sectionDto.setWarehouse_code(1);
        request.setSection(sectionDto);
        List<BatchStockDTO> listaStock = Arrays.asList(
                new BatchStockDTO(1,50,5.0,2.0,150,
                        145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15))

        );
        request.setBatchStock(listaStock);


        User user = new User();
        user.setEmail("jgual@gmail.com");

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setCity("Cordoba");
        warehouse.setManager(user);

        when(warehouseService.findWarehouseById(anyInt())).thenReturn(warehouse);

        Category category = new Category();
        category.setId(2);
        Category category2 = new Category();
        category.setId(1);

        Section section = new Section();
        section.setId(2);
        section.setCategory(category);
        section.setWarehouse(warehouse);
        section.setMaxBatchCapacity(1000);


        when(sectionServiceInternal.searchAndValidateByWarehouseAndQuantity(anyInt(),anyInt(),anyInt())).thenReturn(section);


        Product product = new Product();
        product.setCategory(category2);
        product.setId(50);
        when(productServiceInternal.findById(anyInt())).thenReturn(product);


        Assertions.assertThrows(ApiException.class, () -> inboundOrdenService.create(request,emailUser));
    }

    @Test
    void CreateWhenUserIsNotManagerOfWarehouse_BadRequest() {
        // Preparación
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = new InboundOrderDto();
        request.setOrderNumber(1);
        request.setOrderDate(LocalDate.of(2023, 3, 15));
        SectionDTO sectionDto = new SectionDTO();
        sectionDto.setSection_code(1);
        sectionDto.setWarehouse_code(1);
        request.setSection(sectionDto);
        List<BatchStockDTO> listaStock = Arrays.asList(
                new BatchStockDTO(1, 50, 5.0, 2.0, 150,
                        145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15))

        );
        request.setBatchStock(listaStock);


        User user = new User();
        user.setEmail("joitix@gmail.com");

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setCity("Cordoba");
        warehouse.setManager(user);

        when(warehouseService.findWarehouseById(anyInt())).thenReturn(warehouse);


        Assertions.assertThrows(ApiException.class, () -> inboundOrdenService.create(request,emailUser));


    }

    @Test
    void testUpdateInboundOrderBatchExistSuccessfully() {
        // Declaro email de usuario
        String emailUser = "manager@example.com";
        //Creo request con el numero de orden
        int orderNumber = 1;
        InboundOrderDto request = prepareInboundOrderDto(orderNumber);

        //Creo manager del warehouse
        User manager = new User();
        manager.setEmail(emailUser);
        //Creo warehouse y le asigno su manager
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setManager(manager);

        //Creo seccion
        Section section = new Section(1,warehouse,new Category(1,"Comida","Comida"),100);

        //Creo orden existente para comparar el put
        InboundOrder existingOrder = prepareExistingInboundOrder(orderNumber, section);

        //Mockeo la orden existente traida desde el repo
        when(inboundOrderRepository.findById(anyInt())).thenReturn(Optional.of(existingOrder));

        //Mockeo el warehouse
        when(warehouseService.findWarehouseById(1)).thenReturn(warehouse);

        //Mockeo la seccion para ver si hay stock
        when(sectionServiceInternal.searchAndValidateByWarehouseAndQuantity(1, 1, request.getBatchStock().size())).thenReturn(section);

        //Creo producto para luego mockear la respuesta del servicio
        Product product = new Product();
        product.setCategory(section.getCategory());
        product.setId(50);
        product.setName("carne");
        product.setPrice(200.0);

        //Mockeo respuesta del servicio con el producto
        when(productServiceInternal.findById(anyInt())).thenReturn(product);

        //Mockeo respuesta de batch para devolver uno que ya existe
        when(batchServiceInternal.getEntityByIdOrNull(anyInt())).thenReturn(existingOrder.getBatches().get(0));

        //Mockeo respuesta del update del batch
        when(batchService.addOrUpdateBatchesList(any())).thenReturn(request.getBatchStock());


        //Execute
        BatchStockResponseDTO response = inboundOrdenService.update(request,emailUser );

        //Assertions
        //Valido que tenga una respuesta
        assertNotNull(response);

        //Verifico que se llame al save de la orden
        verify(inboundOrderRepository).save(any(InboundOrder.class));
        //Verfico que se llama al delete de los batches
        verify(batchServiceInternal).DeleteBatchList(anyList());

        //Verifico que el response tenga 2 batches
        assertTrue(response.getBatch_stock().size() == 2);
    }

    @Test
    void testUpdateInboundOrderBatchDoesntExistSuccessfully() {
        // Declaro email de usuario
        String emailUser = "manager@example.com";
        //Creo request con el numero de orden
        int orderNumber = 1;
        InboundOrderDto request = prepareInboundOrderDto(orderNumber);

        //Creo manager del warehouse
        User manager = new User();
        manager.setEmail(emailUser);
        //Creo warehouse y le asigno su manager
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setManager(manager);

        //Creo seccion
        Section section = new Section(1,warehouse,new Category(1,"Comida","Comida"),100);

        //Creo orden existente para comparar el put
        InboundOrder existingOrder = prepareExistingInboundOrder(orderNumber, section);

        //Mockeo la orden existente traida desde el repo
        when(inboundOrderRepository.findById(anyInt())).thenReturn(Optional.of(existingOrder));

        //Mockeo el warehouse
        when(warehouseService.findWarehouseById(1)).thenReturn(warehouse);

        //Mockeo la seccion para ver si hay stock
        when(sectionServiceInternal.searchAndValidateByWarehouseAndQuantity(1, 1, request.getBatchStock().size())).thenReturn(section);

        //Creo producto para luego mockear la respuesta del servicio
        Product product = new Product();
        product.setCategory(section.getCategory());
        product.setId(50);
        product.setName("carne");
        product.setPrice(200.0);

        //Mockeo respuesta del servicio con el producto
        when(productServiceInternal.findById(anyInt())).thenReturn(product);



        //Mockeo respuesta del update del batch
        when(batchService.addOrUpdateBatchesList(any())).thenReturn(request.getBatchStock());


        //Execute
        BatchStockResponseDTO response = inboundOrdenService.update(request,emailUser );

        //Assertions
        //Valido que tenga una respuesta
        assertNotNull(response);

        //Verifico que se llame al save de la orden
        verify(inboundOrderRepository).save(any(InboundOrder.class));
        //Verfico que se llama al delete de los batches
        verify(batchServiceInternal).DeleteBatchList(anyList());

        //Verifico que el response tenga 2 batches
        assertTrue(response.getBatch_stock().size() == 2);
    }

    private InboundOrderDto prepareInboundOrderDto(int orderNumber) {
        InboundOrderDto request = new InboundOrderDto();
        request.setOrderNumber(1);
        request.setOrderDate(LocalDate.of(2023, 3, 15));
        SectionDTO sectionDto = new SectionDTO();
        sectionDto.setSection_code(1);
        sectionDto.setWarehouse_code(1);
        request.setSection(sectionDto);
        List<BatchStockDTO> listaStock = Arrays.asList(
                new BatchStockDTO(1, 50, 5.0, 2.0, 150,
                        145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15)),
                new BatchStockDTO(2,1,5.0,2.0,150,145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15))
        );
        request.setBatchStock(listaStock);

        return request;
    }

    private InboundOrder prepareExistingInboundOrder(int orderNumber, Section section) {

        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setSection(section);
        inboundOrder.setId(orderNumber);
        List<Batch> batchList = new ArrayList<>();

        Product p = new Product();
        p.setId(50);
        p.setName("carne");

        Batch batch = new Batch(2,p,inboundOrder,5.0,2.0,150,145,
                LocalDate.of(2023, 3, 15),
                LocalDateTime.of(2023, 3, 15, 15, 30),
                LocalDate.of(2025, 3, 15));
        batchList.add(batch);
        inboundOrder.setBatches(batchList);


        return inboundOrder;
    }
    @Test
    public void getAllByIdWarehouse_Ok(){
        int idWarehouse = 1;
        String emailUser = "email@gmail.com";
        int expectedQuantity = 1;
        int expectedId = 1;

        User manager = new User();
        manager.setEmail(emailUser);
        Warehouse warehouse = new Warehouse();
        warehouse.setId(idWarehouse);
        warehouse.setManager(manager);

        Section section = new Section();
        section.setId(1);
        section.setWarehouse(warehouse);

        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setId(expectedId);
        inboundOrder.setOrderDate(LocalDate.now());
        inboundOrder.setSection(section);
        List<InboundOrder> inboundOrderList = new ArrayList<>(List.of(inboundOrder));

        when(warehouseService.findWarehouseById(idWarehouse)).thenReturn(warehouse);

        when(inboundOrderRepository.findAllBySection_Warehouse_Id(idWarehouse)).thenReturn(inboundOrderList);

        List<InboundOrderResponseDTO> response = inboundOrdenService.getAllByIdWarehouse(idWarehouse, emailUser);

        Assertions.assertEquals(expectedQuantity, response.size());
        Assertions.assertEquals(expectedId, response.get(0).getOrder_number());

    }

    @Test
    public void getAllByIdWarehouse_Empty(){
        int idWarehouse = 1;
        String emailUser = "email@gmail.com";

        User manager = new User();
        manager.setEmail(emailUser);
        Warehouse warehouse = new Warehouse();
        warehouse.setId(idWarehouse);
        warehouse.setManager(manager);

        List<InboundOrder> listEmpty = new ArrayList<>();

        when(warehouseService.findWarehouseById(idWarehouse)).thenReturn(warehouse);

        when(inboundOrderRepository.findAllBySection_Warehouse_Id(idWarehouse)).thenReturn(listEmpty);

        Assertions.assertThrows(ApiException.class,
                ()->inboundOrdenService.getAllByIdWarehouse(idWarehouse, emailUser));

    }

    @Test
    public void getById_Ok(){
        int idWarehouse = 1;
        String emailUser = "email@gmail.com";
        int expectedId = 1;

        User manager = new User();
        manager.setEmail(emailUser);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(idWarehouse);
        warehouse.setManager(manager);

        Section section = new Section();
        section.setId(1);
        section.setWarehouse(warehouse);

        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setId(expectedId);
        inboundOrder.setOrderDate(LocalDate.now());
        inboundOrder.setSection(section);

        when(inboundOrderRepository.findById(expectedId)).thenReturn(Optional.of(inboundOrder));

        InboundOrderResponseDTO response  = inboundOrdenService.getById(expectedId, emailUser);

        Assertions.assertEquals(expectedId, response.getOrder_number());

    }

    @Test
    public void getById_Empty(){
        String emailUser = "email@gmail.com";
        int id = 1;
        int expectedCode = 404;

        when(inboundOrderRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ApiException.class, ()->inboundOrdenService.getById(id, emailUser));

        ApiException exception = Assertions.assertThrows(ApiException.class,
                ()->inboundOrdenService.getById(id, emailUser));

        Assertions.assertEquals(expectedCode, exception.getStatusCode());
    }

    @Test
    public void getById_Forbidden(){
        int idWarehouse = 1;
        String emailUser = "email@gmail.com";
        int id = 1;

        int expectedCode = 403;

        String emailManager = "manager@gmail.com";

        User manager = new User();
        manager.setEmail(emailManager);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(idWarehouse);
        warehouse.setManager(manager);

        Section section = new Section();
        section.setId(1);
        section.setWarehouse(warehouse);

        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setSection(section);

        when(inboundOrderRepository.findById(id)).thenReturn(Optional.of(inboundOrder));

        ApiException exception = Assertions.assertThrows(ApiException.class,
                ()->inboundOrdenService.getById(id, emailUser));

        Assertions.assertEquals(expectedCode, exception.getStatusCode());
    }






}
