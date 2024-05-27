package com.meli.joyeria.service.impl;

import com.meli.joyeria.model.Joya;
import com.meli.joyeria.repository.IJoyaRepository;
import com.meli.joyeria.service.IJoyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IJoyaServiceImpl implements IJoyaService {
    private final IJoyaRepository joyaRepository;

    @Override
    public String crearJoya(Joya joya) {
        Joya joyaGuardada = joyaRepository.save(joya);
        return String.format("Se creo una nueva joya con el id: %d", joyaGuardada.getId());
    }

    @Override
    public List<Joya> devolverJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public String borrarJoyaLogica(Long id) {
        return "";
    }

    @Override
    public Joya actualizarJoya(Long id, Joya joya) {
        Joya joyaActualizar = obtenerJoyaPorId(id);
        if (joya.getPeso() != null) {
            joyaActualizar.setPeso(joya.getPeso());
        }

        if (joya.getMaterial() != null) {
            joyaActualizar.setMaterial(joya.getMaterial());
        }

        if (joya.getNombre() != null) {
            joyaActualizar.setNombre(joya.getNombre());
        }

        if (joya.getParticularidad() != null) {
            joyaActualizar.setParticularidad(joya.getParticularidad());
        }

        if (joya.isPoseePiedra() == null) {
            joyaActualizar.setPoseePiedra(joya.isPoseePiedra());
        }

        // Verificar y establecer si está a la venta
        if (joya.isVentaOno() != null) {
            joyaActualizar.setVentaOno(joya.isVentaOno());
        }
        return joyaRepository.save(joyaActualizar);
    }

    @Override
    public Joya obtenerJoyaPorId(Long id) {
       Optional<Joya> optionalJoya = joyaRepository.findById(id);
        return optionalJoya.orElse(null);
    }
}
