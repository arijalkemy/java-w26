package meli.bootcamp.hql.service.impl;

import java.util.List;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;
import meli.bootcamp.hql.mapper.SiniestrosMapper;
import meli.bootcamp.hql.model.Siniestro;
import meli.bootcamp.hql.repository.ISiniestrosRepository;
import meli.bootcamp.hql.service.ISiniestrosService;
import org.springframework.stereotype.Service;

@Service
public class SiniestrosServiceImpl implements ISiniestrosService {
    ISiniestrosRepository siniestrosRepository;
    SiniestrosMapper siniestrosMapper;

    public SiniestrosServiceImpl(
        ISiniestrosRepository siniestrosRepository, SiniestrosMapper siniestrosMapper
    ) {
        this.siniestrosRepository = siniestrosRepository;
        this.siniestrosMapper = siniestrosMapper;
    }

    @Override
    public List<SiniestroResDto> saveAll(List<SiniestroReqDto> siniestroReqDtos) {
        List<Siniestro> siniestros = siniestrosMapper.toEntityList(siniestroReqDtos);
        List<Siniestro> siniestrosGuardados = siniestrosRepository.saveAll(siniestros);
        return siniestrosMapper.toDtoList(siniestrosGuardados);
    }
}
