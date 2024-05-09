package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;


@ExtendWith(MockitoExtension.class)
class BuyerRepositoryImplTest {

    @Mock
    private FileDataBaseUtil<Buyer> file;

    @InjectMocks
    private  BuyerRepositoryImpl underTest;

        
    @Test
    void useOfAdd_shouldThrow() {
        assertThrows(UnsupportedOperationException.class , () -> underTest.add(TestGeneratorUtil.createBuyerWithFollowed(1)));
    }

    @Test
    void useOfRemove_shouldThrow() {
        assertThrows(UnsupportedOperationException.class , () -> underTest.remove(TestGeneratorUtil.createBuyerWithFollowed(1)));
    }



}
