package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.User;

public interface IUserService {
    User searchUserById(Integer id);
}
