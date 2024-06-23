package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;

public interface IUserServiceInternal {
    public UserEntity findUserById(Integer id);
}
