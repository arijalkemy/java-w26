package com.mercadolibre.pf_be_hisp_w26_t07_torres.repository;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchesResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.StorageTypeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("integration_test")
@Sql(scripts = "classpath:data.sql")
public class BatchRepositoryTest {
    @Autowired
    private IBatchRepository batchRepository;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    public void testFindBatchesWithDetails() throws Exception {
        LocalDate startDate = LocalDate.of(2024, 6, 5);
        LocalDate endDate = LocalDate.of(2024, 6, 20);
        int representativeId = 1;

        List<IBatchesResponseProjection> results = batchRepository.findBatchesCloseToExpire(
                startDate, endDate, representativeId, OrderEnum.DATE_DESC.getSort()
        );

        assertThat(results).isNotEmpty();

        assertEquals(1, results.size());
    }

    @Test
    public void findBatchesCloseToExpireByCategory() throws Exception {
        LocalDate startDate = LocalDate.of(2024, 6, 5);
        LocalDate endDate = LocalDate.of(2024, 6, 20);
        int representativeId = 1;

        List<IBatchesResponseProjection> results = batchRepository.findBatchesCloseToExpireByCategory(startDate, endDate, representativeId, StorageTypeEnum.FF.getFullName(), OrderEnum.DATE_ASC.getSort());

        assertThat(results).isNotEmpty();

        assertEquals(2, results.size());
    }
}
