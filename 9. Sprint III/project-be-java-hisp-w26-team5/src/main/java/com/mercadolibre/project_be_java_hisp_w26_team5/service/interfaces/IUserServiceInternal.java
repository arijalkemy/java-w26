package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.model.UserEntity;

public interface IUserServiceInternal {
    public UserEntity findUserById(Integer id);
}
