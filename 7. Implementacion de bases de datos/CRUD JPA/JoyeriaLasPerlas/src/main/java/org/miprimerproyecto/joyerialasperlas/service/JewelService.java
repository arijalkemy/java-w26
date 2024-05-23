package org.miprimerproyecto.joyerialasperlas.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.miprimerproyecto.joyerialasperlas.model.Jewel;
import org.miprimerproyecto.joyerialasperlas.repository.IJewelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelService implements IJewelService {

    private final IJewelRepository jewelRepository;


    @Override
    @Transactional (readOnly = true)
    public List<Jewel> getJewel() {
        return getList();
    }

    private List<Jewel> getList(){
        List<Jewel> jewelList=jewelRepository.findAll();
        return jewelList.stream().filter(Jewel::isVentaONo).findFirst().stream().toList();
    }

    @Override
    public void saveJewel(Jewel joy) {
        jewelRepository.save(joy);
    }

    @Override
    @Transactional
    public String deleteJewel(long id) {
        Jewel jewel = this.findJewel(id);
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
        return "La joya con id "+id+" se ha eliminado correctamente";
    }

    @Override
    @Transactional (readOnly = true)
    public Jewel findJewel(long id) {
        return jewelRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public String editJewel(Long id_modificar, Jewel joya_modif) {

        Jewel joyaOriginal = this.findJewel(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJewel(joyaOriginal);
        return "Modificaciones guardadas correctamente";

    }

}
