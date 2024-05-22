package meli.bootcamp.hql.controller;

import jakarta.validation.Valid;
import java.util.List;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;
import meli.bootcamp.hql.service.ISiniestrosService;
import org.springframework.http.ResponseEntity;
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
}
