package org.example.pearl_jewelry.service;

import org.example.pearl_jewelry.dto.JewelDto;
import org.example.pearl_jewelry.dto.SuccessDto;
import org.example.pearl_jewelry.dto.UpdateDto;
import org.example.pearl_jewelry.exceptions.NotFoundException;
import org.example.pearl_jewelry.model.Jewel;
import org.example.pearl_jewelry.repository.IJewelryRepository;
import org.example.pearl_jewelry.service.interfaces.IJewelryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryServiceImp implements IJewelryService {
    private final IJewelryRepository jewelryRepository;

    public JewelryServiceImp(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public SuccessDto createJewel(JewelDto newJewel) {
        /**
         *  1. Crear una nueva joya y devolver el correspondiente status code
         *      con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
         */
        ModelMapper mapper = new ModelMapper();
        Jewel mappedJewel = mapper.map(newJewel, Jewel.class);
        Jewel createdJewel = jewelryRepository.save(mappedJewel);
        return new SuccessDto("Creado con id "+createdJewel.getId());
    }

    @Override
    public List<JewelDto> getJewelList() {
        ModelMapper mapper = new ModelMapper();
        return jewelryRepository.findAll().stream()
                .filter(Jewel::isForSale)
                .map(j -> mapper.map(j, JewelDto.class))
                .toList();
    }

    @Override
    public SuccessDto deleteJewel(Long id) {
        /**
         *  3. Eliminar “lógicamente” una joya. Para ello, se deberá contemplar
         *      un campo que se llama “ventaONo”, el cual debe ser verdadero al
         *      crear una nueva joya, y falso cuando se solicite el eliminado.
         *      En caso de estar eliminado lógicamente, no deberá ser devuelto
         *      en el listado de joyas registradas. (URI: /jewerly/delete/{id})
         */
        Optional<Jewel> foundJewel = jewelryRepository.findById(id);
        if (foundJewel.isEmpty()) {
            throw new NotFoundException("No se encontró el elemento para eliminar con id " + id);
        }
        Jewel jewelToDelete = foundJewel.get();
        jewelToDelete.setForSale(false);
        jewelryRepository.save(jewelToDelete);
        return new SuccessDto("Eliminado correctamente");
    }

    @Override
    public UpdateDto updateJewel(Long id, JewelDto updatedJewel) {
        /**
         *  4. Actualizar los datos de una joya. Una vez actualizados, devolver
         *      un mensaje con el correspondiente status code y los datos de la
         *      joya modificada. (URI: /jewerly/update/{id_modificar}). Envía el
         *      objeto completo para editar (sin cambiar la id).
         */
        ModelMapper mapper = new ModelMapper();
        boolean exists = jewelryRepository.existsById(id);
        if(!exists) {
            throw new NotFoundException("No se encontró el elemento para actualizar con id " + id);
        }
        Jewel newJewel = mapper.map(updatedJewel, Jewel.class);
        newJewel.setId(id);
        jewelryRepository.save(newJewel);
        return new UpdateDto("Se actualizó correctamente", mapper.map(newJewel, JewelDto.class));
    }
}
