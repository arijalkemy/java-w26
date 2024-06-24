package com.mercadolibre.pf_be_hisp_w26_t01_ditta.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.ISectionRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.SectionService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ICategoryServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IUserServiceInternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SectionServiceTest {
    @Mock
    private ISectionRepository sectionRepository;

    @Mock
    private ICategoryServiceInternal categoryServiceInternal;

    @Mock
    private IUserServiceInternal userServiceInternal;

    @InjectMocks
    private SectionService sectionService;

    @Test
    public void save_Ok() {
        // Arrange
        SectionRequestDTO sectionRequestDTO = new SectionRequestDTO(1,1,20);
        String managerEmail = "abcgmail.com";

        User user = new User();
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        user.setWarehouse(warehouse);

        Category category = new Category();
        category.setId(1);

        when(userServiceInternal.searchByEmail(managerEmail)).thenReturn(user);
        when(sectionRepository.findAllByWarehouseId(warehouse.getId())).thenReturn(new ArrayList<>());
        when(categoryServiceInternal.findCategoryById(sectionRequestDTO.getIdCategory())).thenReturn(category);

        // Act
        sectionService.save(sectionRequestDTO, managerEmail);

        // Assert
        verify(sectionRepository, times(1)).save(any(Section.class));
    }

    @Test
    public void save_BadRequest_IdSectionIsNull() {
        // Arrange
        SectionRequestDTO sectionRequestDTO = new SectionRequestDTO(null,1,20);
        String managerEmail = "abcgmail.com";

        User user = new User();
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        user.setWarehouse(warehouse);

        when(userServiceInternal.searchByEmail(managerEmail)).thenReturn(user);

        // Act & Assert
        Assertions.assertThrows(ApiException.class,
                () -> sectionService.save(sectionRequestDTO, managerEmail));
    }

    @Test
    public void save_BadRequest_SectionAlreadyExists() {
        // Arrange
        SectionRequestDTO sectionRequestDTO = new SectionRequestDTO(1,1,20);
        String managerEmail = "abcgmail.com";

        User user = new User();
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        user.setWarehouse(warehouse);
        List<Section> existingSections = List.of(new Section(1, warehouse,null, 20));

        when(userServiceInternal.searchByEmail(managerEmail)).thenReturn(user);
        when(sectionRepository.findAllByWarehouseId(warehouse.getId())).thenReturn(existingSections);

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class,
                () -> sectionService.save(sectionRequestDTO, managerEmail));
    }

    @Test
    public void getAll_Ok() {
        String managerEmail = "abcgmail.com";
        User user = new User();
        Warehouse warehouse = new Warehouse(1,"w1", null, null, user);
        user.setWarehouse(warehouse);
        Category category = new Category(1,"Fresco", "Fresco");
        Section section = new Section(1, warehouse, category, 20);

        List<SectionResponseDTO> expected = List.of(
                new SectionResponseDTO(1, warehouse.getName(), category.getName(),20));

        when(userServiceInternal.searchByEmail(managerEmail)).thenReturn(user);
        when(sectionRepository.findAllByWarehouseId(warehouse.getId())).thenReturn(List.of(section));

        List<SectionResponseDTO> obtained = sectionService.getAll(managerEmail);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void getAll_NotFound() {
        String managerEmail = "abcgmail.com";
        User user = new User();
        Warehouse warehouse = new Warehouse(1,"w1", null, null, user);
        user.setWarehouse(warehouse);

        when(userServiceInternal.searchByEmail(managerEmail)).thenReturn(user);
        when(sectionRepository.findAllByWarehouseId(warehouse.getId())).thenReturn(List.of());

        Assertions.assertThrows(ApiException.class, () -> sectionService.getAll(managerEmail));
    }


}
