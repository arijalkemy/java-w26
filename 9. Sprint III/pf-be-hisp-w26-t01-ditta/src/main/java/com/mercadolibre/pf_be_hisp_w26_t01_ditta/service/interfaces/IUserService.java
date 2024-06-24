package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.User;

public interface IUserService {
    User searchUserById(Integer id);
}
