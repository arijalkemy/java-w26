package com.mercadolibre.sprint_3_valderrama.unit.service;

import com.mercadolibre.sprint_3_valderrama.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.BatchDueDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.ResponseBatchDueDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint_3_valderrama.entity.User;
import com.mercadolibre.sprint_3_valderrama.enums.Category;
import com.mercadolibre.sprint_3_valderrama.exceptions.ApiException;
import com.mercadolibre.sprint_3_valderrama.repository.IBatchStockRepository;
import com.mercadolibre.sprint_3_valderrama.repository.IProductRepository;
import com.mercadolibre.sprint_3_valderrama.repository.ISectionRepository;
import com.mercadolibre.sprint_3_valderrama.repository.IUserRepository;
import com.mercadolibre.sprint_3_valderrama.service.BatchService;
import com.mercadolibre.sprint_3_valderrama.utils.CustomObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTest {

    @Mock
    private ISectionRepository sectionRepository;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IBatchStockRepository batchStockRepository;

    @InjectMocks
    private BatchService batchService;

    @Test
    @DisplayName("get all houses by product id happy path")
    void getAllWarehousesByProductIDHappyPath(){
        //Arrange
        Long input = 1L;
        AllWarehousesDTO expectedOutput = CustomObjectMapper.allWarehousesDTOGenerator();

        //Mock
        Mockito.when(productRepository.findById(input)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(batchStockRepository.findWarehouseStockByProductId(input)).thenReturn(CustomObjectMapper.warehouseProjectionListGenerator());

        //Act
        AllWarehousesDTO  actualOutput = batchService.getAllWarehousesByProductID(input);

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("get all houses by product id no product exception")
    void getAllWarehousesByProductIDSadPath(){
        //Arrange
        Long input = 1L;

        //Mock
        Mockito.when(productRepository.findById(input)).thenReturn(Optional.empty());

        //Act and assert
        assertThrows(ApiException.class, () -> batchService.getAllWarehousesByProductID(input));
    }

    @Test
    @DisplayName("get all houses by product id empty list exception")
    void getAllWarehousesByProductIDEmtyList(){
        //Arrange
        Long input = 1L;

        //Mock
        Mockito.when(productRepository.findById(input)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(batchStockRepository.findWarehouseStockByProductId(input)).thenReturn(List.of());

        //Act and assert
        assertThrows(ApiException.class, () -> batchService.getAllWarehousesByProductID(input));
    }

    @Test
    @DisplayName("get individual warehouse stock by product id")
    void getWarehouseStockByProductIDTest(){
        //Act
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        Mockito.when(batchStockRepository.findByProductIDAndWareHouseID(id, id)).thenReturn(CustomObjectMapper.batchStockProjectionListGenerator());

        //Act
        WarehouseStockDTO  actualOutput = batchService.getWarehouseStockByProductID(id);

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("get individual warehouse stock by product id no user exception")
    void getWarehouseStockByProductIDTestNoUser(){
        //Act
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.empty());


        assertThrows(ApiException.class, () -> batchService.getWarehouseStockByProductID(id));
    }

    @Test
    @DisplayName("get individual warehouse stock by product id")
    void getWarehouseStockByProductIDTestNoProduct(){
        //Act
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());

        //Act
        assertThrows(ApiException.class, () -> batchService.getWarehouseStockByProductID(id));
    }

    @Test
    @DisplayName("get individual warehouse stock by product id")
    void getWarehouseStockByProductIDTestNoSection(){
        //Act
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        //Act
        assertThrows(ApiException.class, () -> batchService.getWarehouseStockByProductID(id));
    }

    /**
     * Test for the method getWarehouseStockByProductIDOrdered in BatchService
     * It test the happy path when the method is called and the order is not null, and it is "L"
     * The method should return a WarehouseStockDTO object
     */
    @Test
    @DisplayName("get warehouse stock by product id ordered happy path, L case order")
    void getWarehouseStockByProductIDOrderedHappyPathL(){
        //Arrange
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;
        // Ordering the list of ResponseBatchDTO by idBatch
        expectedOutput.setBatchDTOList(expectedOutput.getBatchDTOList().
                stream().sorted((o1, o2) -> o1.getIdBatch().compareTo(o2.getIdBatch())).toList());

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        Mockito.when(batchStockRepository.findByProductIDAndWareHouseID(id, id)).thenReturn(CustomObjectMapper.batchStockProjectionListGenerator());
        //Act
        WarehouseStockDTO  actualOutput = batchService.getWarehouseStockByProductIDOrdered(id,"L");

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test for the method getWarehouseStockByProductIDOrdered in BatchService
     * It test the happy path when the method is called and the order is not null, and it is "C"
     * The method should return a WarehouseStockDTO object
     */
    @Test
    @DisplayName("get warehouse stock by product id ordered happy path, C case order")
    void getWarehouseStockByProductIDOrderedHappyPathC(){
        //Arrange
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;
        // Ordering the list of ResponseBatchDTO by currentQuantity
        expectedOutput.setBatchDTOList(expectedOutput.getBatchDTOList().
                stream().sorted((o1, o2) -> o1.getCurrentQuantity().compareTo(o2.getCurrentQuantity())).toList());

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        Mockito.when(batchStockRepository.findByProductIDAndWareHouseID(id, id)).thenReturn(CustomObjectMapper.batchStockProjectionListGenerator());
        //Act
        WarehouseStockDTO  actualOutput = batchService.getWarehouseStockByProductIDOrdered(id,"C");

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test for the method getWarehouseStockByProductIDOrdered in BatchService
     * It test the happy path when the method is called and the order is not null, and it is "F"
     * The method should return a WarehouseStockDTO object
     */
    @Test
    @DisplayName("get warehouse stock by product id ordered happy path, F case order")
    void getWarehouseStockByProductIDOrderedHappyPathF(){
        //Arrange
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;
        // Ordering the list of ResponseBatchDTO by dueDate
        expectedOutput.setBatchDTOList(expectedOutput.getBatchDTOList().
                stream().sorted((o1, o2) -> o1.getDueDate().compareTo(o2.getDueDate())).toList());

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        Mockito.when(batchStockRepository.findByProductIDAndWareHouseID(id, id)).thenReturn(CustomObjectMapper.batchStockProjectionListGenerator());
        //Act
        WarehouseStockDTO  actualOutput = batchService.getWarehouseStockByProductIDOrdered(id,"F");

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test for the method getWarehouseStockByProductIDOrdered in BatchService
     * It test the bad path when the method is called and the order is not null, and it is not "L", "C" or "F"
     * The method should throw an exception
     */
    @Test
    @DisplayName("get warehouse stock by product id ordered bad path, invalid order")
    void getWarehouseStockByProductIDOrderedBadPath(){
        //Arrange
        WarehouseStockDTO expectedOutput = CustomObjectMapper.warehouseStockDTOGenerator();
        String userName = "Test";
        Long id = 1L;

        //Mock

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Mockito.when(authentication.getName()).thenReturn(userName);
        Mockito.when(userRepository.findByUsername(userName)).thenReturn(Optional.of(User.builder().id(id).build()));
        Mockito.when(userRepository.findWarehousesByUserId(Mockito.any(Long.class))).thenReturn(CustomObjectMapper.warehouseGenerator());
        Mockito.when(productRepository.findById(id)).thenReturn(CustomObjectMapper.productGenerator());
        Mockito.when(sectionRepository.findSectionByProductIdAndWarehouseId(id, id)).thenReturn(CustomObjectMapper.sectionGenerator());
        Mockito.when(batchStockRepository.findByProductIDAndWareHouseID(id, id)).thenReturn(CustomObjectMapper.batchStockProjectionListGenerator());
        //Act and assert
        assertThrows(ApiException.class, () -> batchService.getWarehouseStockByProductIDOrdered(id,"A"));
    }

    @Test
    @DisplayName("Test for the getDueBatchesByDaysAndCategory method in BatchService.")
    void testGetDueBatchesByDaysAndCategory() {
        // Arrange
        int days = 30;
        Category category = Category.FS;
        String order = "date_asc";
        LocalDate today = LocalDate.now();
        List<BatchDueDTO> batchDueDTOList = new ArrayList<>();
        batchDueDTOList.add(new BatchDueDTO(1L, 1L, Category.FS, Date.valueOf(today.plusDays(15)), 100));

        when(batchStockRepository.findProductsBetweenDateAndCategory(1L, Date.valueOf(today), Date.valueOf(today.plusDays(days)), category, order)).thenReturn(batchDueDTOList);

        // Act
        ResponseBatchDueDTO result = batchService.getDueBatchesByDaysAndCategory(days, category, order);

        // Assert
        assertEquals(batchDueDTOList, result.getBatchDueDTOList());
    }

    @Test
    @DisplayName("Test for the getDueBatchesByDaysAndCategory method in BatchService when no products are found.")
    void testGetDueBatchesByDaysAndCategory_NotFound() {
        // Arrange
        int days = 30;
        Category category = Category.FF;
        String order = "date_desc";
        LocalDate today = LocalDate.now();
        List<BatchDueDTO> emptyList = new ArrayList<>();

        when(batchStockRepository.findProductsBetweenDateAndCategory(1L, Date.valueOf(today), Date.valueOf(today.plusDays(days)), category, order)).thenReturn(emptyList);

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () ->
                batchService.getDueBatchesByDaysAndCategory(days, category, order));

        assertEquals("No se encontraron productos con las características solicitadas", exception.getMessage());
        assertEquals("No se encontraron productos con las características solicitadas", exception.getDescription());
        assertEquals(404, exception.getStatusCode());
    }


}
