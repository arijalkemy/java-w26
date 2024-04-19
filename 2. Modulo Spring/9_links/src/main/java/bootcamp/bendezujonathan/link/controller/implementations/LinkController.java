package bootcamp.bendezujonathan.link.controller.implementations;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import bootcamp.bendezujonathan.link.controller.interfaces.ILinkController;
import bootcamp.bendezujonathan.link.dto.request.LinkRequest;
import bootcamp.bendezujonathan.link.dto.response.LinkResponse;
import bootcamp.bendezujonathan.link.service.interfaces.ILinkService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LinkController implements ILinkController {

    private final ILinkService service;

    @Override
    public ResponseEntity<LinkResponse> postLink(LinkRequest request) {
        LinkResponse response = this.service.createLink(request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<LinkResponse>> getAll() {
        List<LinkResponse> responses = this.service.searchAll();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> getById(int linkId, String password) {
        LinkResponse founded = this.service.searchById(linkId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.fromUriString(founded.getUrl()).build().toUri());
        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @Override
    public ResponseEntity<Void> patchInvalidate(int id) {
        this.service.invalidateLink(id);
        return ResponseEntity.ok()
                .build();
    }

}
