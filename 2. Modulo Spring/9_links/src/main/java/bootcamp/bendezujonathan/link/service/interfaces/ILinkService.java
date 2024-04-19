package bootcamp.bendezujonathan.link.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.link.dto.request.LinkRequest;
import bootcamp.bendezujonathan.link.dto.response.LinkResponse;

public interface ILinkService {
	
    LinkResponse createLink(LinkRequest request);
    LinkResponse searchById(int id);
    void invalidateLink(int id);
    LinkResponse searchMetrics(int id);
    List<LinkResponse> searchAll();

    
}
