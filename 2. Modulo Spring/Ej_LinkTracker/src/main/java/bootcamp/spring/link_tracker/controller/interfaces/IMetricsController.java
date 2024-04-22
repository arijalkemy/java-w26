package bootcamp.spring.link_tracker.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IMetricsController{
    @GetMapping("/{id}")
    ResponseEntity<String> getNumberOfRedirect(@PathVariable Integer id); 
}
