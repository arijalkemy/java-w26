package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;


@ExtendWith(MockitoExtension.class)
class SellerRepositoryImplTest {

   @Mock
    private FileDataBaseUtil<Seller> file;

    @InjectMocks
    private  SellerRepositoryImpl underTest;

        
    @Test
    void useOfAdd_shouldThrow() {
        assertThrows(UnsupportedOperationException.class , () -> underTest.add(TestGeneratorUtil.createSellerWithFollowers(1)));
    }

    @Test
    void useOfRemove_shouldThrow() {
        assertThrows(UnsupportedOperationException.class , () -> underTest.remove(TestGeneratorUtil.createSellerWithFollowers(1)));
    }


}
