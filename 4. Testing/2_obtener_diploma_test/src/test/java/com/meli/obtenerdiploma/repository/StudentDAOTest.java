package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


class StudentDAOTest {

    private StudentDAO underTest = new StudentDAO();

    @Test
    void giveNoExistsId_whenRemove_thenFalse() {
        long notExistId = Integer.MAX_VALUE;
        assertEquals(false, underTest.delete(notExistId));
    }

    // @Test
    // void givenExisteId_whenRemove_thenTrue() {
    //     long id = 2L;
    //     assertEquals(true, underTest.delete(id));
    // }

    @Test
    void testExists() {
        
    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
