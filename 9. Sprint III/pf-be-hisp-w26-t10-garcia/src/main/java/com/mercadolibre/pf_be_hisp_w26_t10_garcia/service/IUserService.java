package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;

public interface IUserService {

     UserAccount findById(Long id);

}
