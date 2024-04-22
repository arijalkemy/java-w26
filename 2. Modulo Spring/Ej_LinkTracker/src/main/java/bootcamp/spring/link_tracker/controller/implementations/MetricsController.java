package bootcamp.spring.link_tracker.controller.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.link_tracker.controller.interfaces.IMetricsController;
import bootcamp.spring.link_tracker.service.interfaces.ILinkService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController implements IMetricsController {

    private final ILinkService linkService;

    @Override
    public ResponseEntity<String> getNumberOfRedirect(Integer id) {
        Integer timesRedirected = linkService.searchTimesRedirected(id);
        return ResponseEntity.ok("Cantidad de veces que se redirecciono: " + timesRedirected);
    }
    
}
