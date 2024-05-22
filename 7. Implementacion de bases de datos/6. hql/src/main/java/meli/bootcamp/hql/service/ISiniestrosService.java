package meli.bootcamp.hql.service;

import java.util.List;
import meli.bootcamp.hql.dto.PatenteModeloMarcaDto;
import meli.bootcamp.hql.dto.PatenteModeloMarcaTotalDto;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;

public interface ISiniestrosService {
    List<SiniestroResDto> saveAll(List<SiniestroReqDto> siniestroReqDtos);

    List<PatenteModeloMarcaDto> getPatenteModeloMarcaPeridasMayorA10000();

    PatenteModeloMarcaTotalDto getPatenteModeloMarcaTotalPeridasMayorA10000();
}
