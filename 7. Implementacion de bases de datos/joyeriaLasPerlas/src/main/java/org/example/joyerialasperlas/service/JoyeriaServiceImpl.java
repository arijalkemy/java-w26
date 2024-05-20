package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.DTO.JoyaResquestDTO;
import org.example.joyerialasperlas.exception.BadRequestException;
import org.example.joyerialasperlas.model.JoyaModel;
import org.example.joyerialasperlas.repository.IJoyeriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JoyeriaServiceImpl implements IJoyeriaService{

    static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    IJoyeriaRepository joyeriaRepository;

    @Override
    public UUID saveJoyeria(JoyaResquestDTO joyaResquestDTO) {
        joyaResquestDTO.setVentaONo(true);
        JoyaModel joyaModel = modelMapper.map(joyaResquestDTO, JoyaModel.class);

        try {
            JoyaModel joyaModelId = joyeriaRepository.save(joyaModel);
            return joyaModelId.getId();
        } catch (Exception e) {
            throw new BadRequestException("Error al guardar la joya");
        }

    }

    @Override
    public List<JoyaResquestDTO> listAllJoyeria() {


        try {
            List<JoyaModel> listJoyaModel = joyeriaRepository.findAll();

            return listJoyaModel.stream()
                    .map(joyaModel -> modelMapper.map(joyaModel, JoyaResquestDTO.class)).toList();

        } catch (Exception e) {
            throw new BadRequestException("No hay joyas en la base de datos");
        }

    }

    @Override
    public JoyaResquestDTO updateJoyeria(UUID id, JoyaResquestDTO joyaResquestDTO) {

        try {
            Optional<JoyaModel> joyaModel = joyeriaRepository.findById(id);

            joyaModel.stream().forEach(joyaModel1 -> {
                joyaModel1.setNombre(joyaResquestDTO.getNombre());
                joyaModel1.setMaterial(joyaResquestDTO.getMaterial());
                joyaModel1.setPeso(joyaResquestDTO.getPeso());
                joyaModel1.setParticularidad(joyaResquestDTO.getParticularidad());
                joyaModel1.setPoseePiedra(joyaResquestDTO.isPoseePiedra());
                joyaModel1.setVentaONo(joyaResquestDTO.isVentaONo());
            });

            JoyaModel resultaJoyaUpdate = joyeriaRepository.save(joyaModel.get());

            return modelMapper.map(resultaJoyaUpdate, JoyaResquestDTO.class);

        } catch (Exception e) {
            throw new BadRequestException("Joya no encontradafeef");
        }

    }

    @Override
    public void deleteJoyeria(UUID id) {

        try {
            Optional<JoyaModel> deleteJoya = joyeriaRepository.findById(id);

            if(deleteJoya.get().isVentaONo()){
                deleteJoya.get().setVentaONo(false);
            }

            joyeriaRepository.save(deleteJoya.get());
        } catch (Exception e) {
            throw new BadRequestException("Joya no encontrada");
        }
    }
}
