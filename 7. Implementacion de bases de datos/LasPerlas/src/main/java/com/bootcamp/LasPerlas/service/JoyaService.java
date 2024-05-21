package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepo;

    @Override
    public String saveJoya(Joya joya) {
       joyaRepo.save(joya);

       return joya.getNro_id().toString();
    }

    @Override
    public List<Joya> getJoyas() {

        return joyaRepo.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList());

    }

    @Override
    public Joya findJoya(Long id) {
        //el orElse nos permite devolver null en caso que no encuentre
        return joyaRepo.findById(id).orElse(null);
    }

    @Override
    public String deleteJoya(Long id) {

        //haremos borrado lógico, por lo cual no eliminamos el registro de la bd
        //sino que solo cambiamos su estado de verdadero (a la venta) a falso (no a la venta)

        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return "Joya dada de baja para la venta correctamente";
    }

    @Override
    public Joya editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return joyaOriginal;

    }
}
