package com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;

public interface IUserServiceInternal {
    User searchByEmail(String email);
    User searchByEmailOrNUll(String email);

    User saveUser(User user);
}
