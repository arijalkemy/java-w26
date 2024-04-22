package bootcamp.spring.link_tracker.controller.implementations;

import java.io.IOException;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.link_tracker.controller.interfaces.ILinkController;
import bootcamp.spring.link_tracker.dto.request.LinkDTOrequest;
import bootcamp.spring.link_tracker.dto.response.LinkDTOresponse;
import bootcamp.spring.link_tracker.service.interfaces.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/links")
@RequiredArgsConstructor
public class LinkController implements ILinkController{

    private final ILinkService linkService;


    @Override
    public ResponseEntity<LinkDTOresponse> post(@RequestBody LinkDTOrequest obj) {
        LinkDTOresponse link = linkService.save(obj);
        return ResponseEntity.ok(link);       
    }


    @Override
    public void redirectToUrl(Integer id,HttpServletResponse response) throws IOException {
        String link = linkService.searchUrlLinkById(id);
        if(Objects.isNull(link)){
            response.sendError(404);
        }
        else{
            response.sendRedirect(link);
        }
    }


    @Override
    public ResponseEntity<String> invalidateLink(Integer id) {
        linkService.invalidateLink(id);
        return ResponseEntity.ok("Link invalidado con exito.");
    }


	
}
