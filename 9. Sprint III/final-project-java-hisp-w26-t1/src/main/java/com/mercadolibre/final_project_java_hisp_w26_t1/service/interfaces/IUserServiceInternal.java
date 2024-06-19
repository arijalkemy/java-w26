package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.User;

public interface IUserServiceInternal {
    User searchByEmail(String email);
}
