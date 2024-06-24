package org.example.templatemvc.Service.in;

import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.DTOs.Response.PatenteMarcaTotalPerdida;
import org.example.templatemvc.Repository.Entity.Siniestro;

import java.util.List;

public interface ISiniestroService {
    List<Siniestro> searchAll();

    Siniestro create(Siniestro request);

    //falta modelo
    List<PatenteMarca> findAllByPerdidaGreaterThan(Double perdida);

    List<PatenteMarcaTotalPerdida> findAllPatenteMarcaSumPerdida();

}
