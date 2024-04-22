package bootcamp.spring.link_tracker.controller.interfaces;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bootcamp.spring.link_tracker.dto.request.LinkDTOrequest;
import bootcamp.spring.link_tracker.dto.response.LinkDTOresponse;
import bootcamp.spring.link_tracker.model.Link;
import jakarta.servlet.http.HttpServletResponse;

public interface ILinkController extends IController<Link>{
    
    @PostMapping
    ResponseEntity<LinkDTOresponse> post(@RequestBody LinkDTOrequest obj);

    @GetMapping("/{id}")
    void redirectToUrl(@PathVariable Integer id, HttpServletResponse response) throws IOException;

    @PostMapping("invalidate/{id}")
    ResponseEntity<String> invalidateLink(@PathVariable Integer id);
}
