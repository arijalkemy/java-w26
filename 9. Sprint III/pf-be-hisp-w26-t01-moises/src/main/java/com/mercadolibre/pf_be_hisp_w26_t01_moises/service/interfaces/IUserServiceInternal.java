package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.User;

public interface IUserServiceInternal {
    User searchByEmail(String email);
    User searchUserById(Integer id);
}
