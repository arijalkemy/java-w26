package com.example.JoyeriaLasPerlas.service.implement;

import com.example.JoyeriaLasPerlas.model.Joya;
import com.example.JoyeriaLasPerlas.repository.IJoyaRepository;
import com.example.JoyeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {
    @Autowired
    IJoyaRepository joyaRepository;


    @Override
    public String saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return "Joya guardada correctamente nro identificatorio: "
                +joya.getNro_identificatorio();
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll().stream()
                .filter(joya -> joya.getVentaONo().equals(true)).toList();
    }

    @Override
    public Joya findJoya(Long id) {
        //el orElse nos permite devolver null en caso que no encuentre
        return joyaRepository.findById(id).orElse(null);
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
    public String editJoya(Long id_modificar, Joya joya_modif) {
        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.getPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.getVentaONo());

        this.saveJoya(joyaOriginal);
        return "Modificaciones guardadas correctamente: "+joyaOriginal.toString();
    }
}
