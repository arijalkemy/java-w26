package bootcamp.bd.clothes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.bd.clothes.dto.ClotheDto;
import bootcamp.bd.clothes.model.Clothe;
import bootcamp.bd.clothes.repository.ClotheRepository;
import bootcamp.bd.clothes.util.ClotheMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClotheServiceImpl implements ClotheService {

    private final ClotheRepository clotheRepository;

    @Override
    public void create(ClotheDto clotheDto) {
        this.clotheRepository
                .save(ClotheMapper.dtoToEntity(clotheDto));
    }

    @Override
    public List<ClotheDto> searchAll() {
        return this.clotheRepository
                .findAll()
                .stream()
                .map(ClotheMapper::entityToDto)
                .toList();
    }

    @Override
    public ClotheDto searchByCode(Integer code) {
        return this.clotheRepository
                .findById(code)
                .map(ClotheMapper::entityToDto)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void modify(ClotheDto clotheDto, Integer code) {
        this.clotheRepository
                .findById(code)
                .ifPresentOrElse(c -> {
                    ClotheMapper.modifyClothe(clotheDto, c);
                    clotheRepository.save(c);
                },null);

    }

    @Override
    public void delete(Integer code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ClotheDto> searchAllBySize(Integer size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAllBySize'");
    }

    @Override
    public List<ClotheDto> searchAllWithNameIncludes(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAllWithNameIncludes'");
    }

}
