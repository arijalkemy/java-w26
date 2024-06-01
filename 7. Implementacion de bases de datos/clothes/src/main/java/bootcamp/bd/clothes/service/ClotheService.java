package bootcamp.bd.clothes.service;

import java.util.List;

import bootcamp.bd.clothes.dto.ClotheDto;

public interface ClotheService {
    void create(ClotheDto clotheDto);
    List<ClotheDto> searchAll();
    ClotheDto searchByCode(Integer code);
    void modify(ClotheDto clotheDto, Integer code);
    void delete(Integer code);
    List<ClotheDto> searchAllBySize(Integer size);
    List<ClotheDto> searchAllWithNameIncludes(String name);
}
