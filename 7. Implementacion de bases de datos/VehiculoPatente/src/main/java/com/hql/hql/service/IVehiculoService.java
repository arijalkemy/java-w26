package com.hql.hql.service;

import com.hql.hql.dto.VehiculoPatenteMarcaDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> findLicensePlate(  );
    List<VehiculoPatenteMarcaDTO> findPatenteMarcaInOrder();
    List<String> findLicenseByCurrentYear(  );
}
