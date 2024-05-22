package bootcamp.vivo.obras.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.vivo.obras.controller.interfaces.ObraController;
import bootcamp.vivo.obras.dto.request.ObraRequest;
import bootcamp.vivo.obras.dto.response.ObraResponse;
import bootcamp.vivo.obras.service.interfaces.ObraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ObraControllerImpl implements ObraController {
    
    private final ObraService service;

    @Override
    public ResponseEntity<List<ObraResponse>> getAll() {
        return transformToResponse(service.findAll());
    }

    @Override
    public ResponseEntity<Void> postObra(ObraRequest req) {
        service.create(req);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> postAllObra(List<ObraRequest> req) {
        service.createInBatch(req);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ObraResponse>> getAllByAutorName(String autor) {
        return transformToResponse(service.findAllByAutor(autor));
    }

    @Override
    public ResponseEntity<List<ObraResponse>> getAllByTitle(String titulo) {
        return transformToResponse(service.findAllByTitle(titulo));
    }

    @Override
    public ResponseEntity<List<ObraResponse>> getTop5CantidadPaginas() {
        return transformToResponse(service.findTop5CantidadPaginas());
    }

    @Override
    public ResponseEntity<List<ObraResponse>> getAllBeforeYear(int year) {
        return transformToResponse(service.findBeforeYear(year));
    }
    
    @Override
    public ResponseEntity<List<ObraResponse>> getAllByEditorial(String editorial) {
        return transformToResponse(service.findByEditorialNombre(editorial));
    }


    private ResponseEntity<List<ObraResponse>> transformToResponse(List<ObraResponse> res){
        return ResponseEntity.ok(res);
    }


    

}
