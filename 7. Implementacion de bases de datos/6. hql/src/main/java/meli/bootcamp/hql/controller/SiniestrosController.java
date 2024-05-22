package meli.bootcamp.hql.controller;

import jakarta.validation.Valid;
import java.util.List;
import meli.bootcamp.hql.dto.PatenteModeloMarcaDto;
import meli.bootcamp.hql.dto.PatenteModeloMarcaTotalDto;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;
import meli.bootcamp.hql.service.ISiniestrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestros")
public class SiniestrosController {
    ISiniestrosService siniestrosService;

    public SiniestrosController(ISiniestrosService siniestrosService) {
        this.siniestrosService = siniestrosService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<SiniestroResDto>> saveAll(
        @RequestBody @Valid List<SiniestroReqDto> siniestroReqDtos
    ) {
        return ResponseEntity.ok(siniestrosService.saveAll(siniestroReqDtos));
    }

    @GetMapping("/patente-modelo-marca-perdida-mayor-a-10000")
    public ResponseEntity<List<PatenteModeloMarcaDto>> getPatenteModeloMarcaPerdidaMayorA10000() {
        return ResponseEntity.ok(siniestrosService.getPatenteModeloMarcaPeridasMayorA10000());
    }

    @GetMapping("/patente-modelo-marca-total-perdida-mayor-a-10000")
    public ResponseEntity<PatenteModeloMarcaTotalDto> getPatModeloMarcaTotalPerdidaMayorA10000() {
        return ResponseEntity.ok(siniestrosService.getPatenteModeloMarcaTotalPeridasMayorA10000());
    }
}
