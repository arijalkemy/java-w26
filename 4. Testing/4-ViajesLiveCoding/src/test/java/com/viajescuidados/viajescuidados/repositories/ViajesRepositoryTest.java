package com.viajescuidados.viajescuidados.repositories;

import com.viajescuidados.repositories.ViajesRepository;
import org.junit.jupiter.api.BeforeAll;

public class ViajesRepositoryTest {
    static ViajesRepository viajesRepository;

    @BeforeAll
    public static void setUp() {
        viajesRepository = new ViajesRepository();
    }
}
