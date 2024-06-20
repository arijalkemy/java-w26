package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.*;

import java.util.List;

public interface IReturnService {

    ResponseCreateReturnDTO createReturn(RequestReturnDTO newReturnDTO);
    List<ResponseReturnsDTO> getAllReturnsByStatus(String status);
    ResponseUpdateReturnStatusDTO updateReturnStatus(Long id, RequestUpdateReturnStatusDTO requestUpdateReturnStatusDTO);
    ResponseReturnsDTO getReturnById(Long id);
}
