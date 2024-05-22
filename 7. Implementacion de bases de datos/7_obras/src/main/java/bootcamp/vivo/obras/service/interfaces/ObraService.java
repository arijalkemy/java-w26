package bootcamp.vivo.obras.service.interfaces;

import java.util.List;

import bootcamp.vivo.obras.dto.request.ObraRequest;
import bootcamp.vivo.obras.dto.response.ObraResponse;

public interface ObraService {
    void create(ObraRequest req);
    void createInBatch(List<ObraRequest> req);
    List<ObraResponse> findAll();
    List<ObraResponse> findAllByAutor(String name);
    List<ObraResponse> findAllByTitle(String title);
    List<ObraResponse> findTop5CantidadPaginas();
    List<ObraResponse> findBeforeYear(int year);
    List<ObraResponse> findByEditorialNombre(String name);
}
