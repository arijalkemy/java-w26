package org.example.templatemvc.Service.in;

import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.Repository.Entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> searchAll();
    Vehiculo create(Vehiculo vehiculo);
    List<String> listAllPlates();
    List<PatenteMarca> searchAllPatenteMarcaOrderAsc();
    List<String> searchAllPatentesByAnioAndCantRuedas(Integer anio);

}
