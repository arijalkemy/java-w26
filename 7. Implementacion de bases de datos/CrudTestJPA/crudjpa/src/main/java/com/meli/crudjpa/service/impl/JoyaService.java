package com.meli.crudjpa.service.impl;

import com.meli.crudjpa.model.DTO.JoyaDTO;
import com.meli.crudjpa.model.Joya;
import com.meli.crudjpa.repository.JoyaRepository;
import com.meli.crudjpa.service.IjoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JoyaService implements IjoyaService {

    @Autowired
    private JoyaRepository joyaRepository;

    @Override
    public String crearJoya(JoyaDTO joya) {
        Joya joyaModel = convertToModel(joya);
        if(joyaRepository.existsById(joyaModel.getNro_identificatorio()))
            throw new RuntimeException("La joya ya existe");
        joyaRepository.save(joyaModel);
        return "Se ha creado con exito la joya id: "+joyaModel.getNro_identificatorio();
    }

    @Override
    public String actualizarJoya(int idJoya, JoyaDTO joya) {
        Joya joyaModel = joyaRepository.findById(idJoya).orElse(null);
        if(joyaModel == null)
            throw new RuntimeException("La joya no existe");
        joya.setNro_identificatorio(joyaModel.getNro_identificatorio());
        joyaRepository.save(convertToModel(joya));
        return "Se ha actualizado con exito la joya id: "+idJoya;
    }

    @Override
    public String eliminarJoya(int id) {
        if(!joyaRepository.existsById(id))
            throw new RuntimeException("La joya no existe");
        joyaRepository.deleteById(id);
        return "Se ha eliminado con exito la joya id: "+id;
    }

    @Override
    public JoyaDTO buscarJoyaPorId(int id) {
        Joya joyaModel = joyaRepository.findById(id).orElse(null);
        if(joyaModel == null)
            throw new RuntimeException("La joya no existe");
        return convertToDto(joyaModel) ;
    }

    @Override
    public List<JoyaDTO> buscarTodasLasJoyas() {
        return joyaRepository.findAll().stream()
                .filter(Joya::isVentaONo)
                .map(this::convertToDto).toList();

    }


    public JoyaDTO convertToDto(Joya joya) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(joya, JoyaDTO.class);
    }
    public Joya convertToModel(JoyaDTO joyaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(joyaDTO, Joya.class);
    }

}
