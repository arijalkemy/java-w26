package com.hql.hql.service;

import com.hql.hql.DTO.VehiculoPatenteMarcaDTO;
import com.hql.hql.model.Vehiculo;
import java.util.List;

public interface IVehiculoService {

    List<String> findLicensePlate(  );
    List<VehiculoPatenteMarcaDTO> findPatenteMarcaInOrder();
    List<String> findLicenseByCurrentYear(  );
}
