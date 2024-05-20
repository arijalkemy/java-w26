package bootcamp.base.miniseries.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import bootcamp.base.miniseries.controller.interfaces.IMiniSerieController;
import bootcamp.base.miniseries.dto.response.MiniSerieResponse;
import bootcamp.base.miniseries.service.interfaces.IMiniSerieService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class MiniSerieController implements IMiniSerieController {

    private final IMiniSerieService serieService;

    @Override
    public ResponseEntity<List<MiniSerieResponse>> findAll() {
        return ResponseEntity.ok(serieService.findAll());
    }

    @Override
    public ResponseEntity<MiniSerieResponse> findById(long id) {
        return ResponseEntity.ok(serieService.findById(id));
    }
    
}
