package meli.bootcamp.hql.service;

import java.util.List;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;

public interface ISiniestrosService {
    List<SiniestroResDto> saveAll(List<SiniestroReqDto> siniestroReqDtos);
}
