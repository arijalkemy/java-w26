package com.jewelry.perls.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jewelry.perls.dto.JewerDto;
import com.jewelry.perls.entity.Jewer;
import com.jewelry.perls.repository.IJewerRepository;
import com.jewelry.perls.service.IJewerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewerServiceImpl implements IJewerService {

    @Autowired
    IJewerRepository jewerRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     *
     * @param
     * @return retorna la lista de joyas
     */
    @Override
    @Transactional
    public List<Jewer> getAll() {
        List<Jewer> jewer = this.jewerRepository.findAll();
        if (!jewer.isEmpty()) {
            return jewer;
        } else {
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param jewerDto : Recibe el dto de la joya a almacenar
     * @return retorna el mensaje indicador
     */
    @Override
    public String saveJewer(JewerDto jewerDto) {
        jewerDto.setVentaONo(true);
        Jewer jewer = this.jewerRepository.save(objectMapper.convertValue(jewerDto, Jewer.class));
        return "Se ha guardado el registro con nro: " + jewer.getNro_identificatorio();
    }

    /**
     *
     * @param jewerDto : nuevo json de la joya modificada
     * @param id : id de la joya a modificar
     * @return retorna la lista de joyas
     */
    @Override
    public Jewer changeJewer(JewerDto jewerDto, Integer id) {

        Optional<Jewer> jewerList = this.jewerRepository.findById(id);

        if (jewerList.isPresent()) {
            Jewer jewer = new Jewer(id,jewerDto.getNombre(),jewerDto.getMaterial(),jewerDto.getPeso(),jewerDto.getParticularidad(),jewerDto.isPosee_piedra(),jewerDto.isVentaONo());
            this.jewerRepository.saveAndFlush(jewer);
            return jewer;
        } else {
            throw new IllegalArgumentException("No se encontró el registro");
        }
    }

    /**
     *
     * @param id
     * @return retorna el mensaje indicador de respuesta
     */
    @Override
    public String deleteJewer(Integer id) {
        Optional<Jewer> jewerList = this.jewerRepository.findById(id);

        if (jewerList.isPresent()) {
            Jewer jewer = jewerList.get();
            if (jewer.isVentaONo()){
                this.jewerRepository.deleteById(id);
                return "Se ha eliminado el registro " + id;
            }
            else {
                return "El registro no puede ser eliminado porque es venta";
            }
        } else {
            return "El registro no se encuentra en la base de datos";
        }
    }
}
