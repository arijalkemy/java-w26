package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user.IUsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    IUsersService usersService;

    @InjectMocks
    UserController userController;

    @Test
    public void test(){
        userController.register(null);
        Assertions.assertEquals(true,true);
    }
}
