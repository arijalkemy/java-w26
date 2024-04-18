package bootcamp.bendezujonathan.blogs.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.blogs.dto.request.EntradaDeBlogRequest;
import bootcamp.bendezujonathan.blogs.dto.response.EntradaDeBlogResponse;

public interface IBlogService {
    EntradaDeBlogResponse create(EntradaDeBlogRequest request);
    List<EntradaDeBlogResponse> findAll();
    EntradaDeBlogResponse searchById(int id);
}
