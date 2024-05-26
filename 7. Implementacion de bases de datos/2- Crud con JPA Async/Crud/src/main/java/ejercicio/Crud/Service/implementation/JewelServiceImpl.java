package ejercicio.Crud.Service.implementation;


import ejercicio.Crud.DTO.Request.JewelRequestDto;
import ejercicio.Crud.DTO.Response.JewelResponseDto;
import ejercicio.Crud.Entity.Jewel;
import ejercicio.Crud.Exception.JewelNotFoundException;
import ejercicio.Crud.Repository.IJewelRepository;
import ejercicio.Crud.Service.IJewelService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JewelServiceImpl implements IJewelService {
    private final IJewelRepository jewelRepository;
    private final ModelMapper modelMapper;

    public JewelServiceImpl(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        this.modelMapper = new ModelMapper();
    }
    public static void setSaleStatus(Jewel jewel, boolean soldOrNot){
        jewel.setSoldOrNot(soldOrNot);
    }

    @Transactional
    @Override
    public JewelResponseDto saveJewel(JewelRequestDto jewelRequestDto) {
        Jewel jewel = modelMapper.map(jewelRequestDto, Jewel.class);
        setSaleStatus(jewel, true);
        jewelRepository.save(jewel);
        return modelMapper.map(jewel, JewelResponseDto.class);
    }


    @Override
    public List<JewelResponseDto> getAllJewells() {
        List<Jewel> jewelList = jewelRepository.findAll();

        List<JewelResponseDto> jewelResponseDtoList = jewelList
                .stream()

                .map(jewel -> modelMapper.map(jewel, JewelResponseDto.class)).collect(Collectors.toList());

        return jewelResponseDtoList;
    }

    @Transactional
    @Override
    public void deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(
                () -> new JewelNotFoundException("Jewel not found with id: " + id));
        jewelRepository.delete(jewel);
        setSaleStatus(jewel, false);
    }

    @Transactional
    @Override
    public void updateJewel(JewelRequestDto jewelRequestDto, Long id) {
        Optional<Jewel> jewel = jewelRepository.findById(id);
        Jewel jewelToUpdate = jewel.get();
        jewelToUpdate.setParticularity(jewelRequestDto.getParticularity());
        modelMapper.map(jewelToUpdate, jewelRequestDto);
    }
}
