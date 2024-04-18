package bootcamp.bendezujonathan.blogs.service.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.blogs.dto.request.EntradaDeBlogRequest;
import bootcamp.bendezujonathan.blogs.dto.response.EntradaDeBlogResponse;
import bootcamp.bendezujonathan.blogs.exceptions.BlogNoCreatedException;
import bootcamp.bendezujonathan.blogs.exceptions.NotFoundException;
import bootcamp.bendezujonathan.blogs.model.EntradaDeBlog;
import bootcamp.bendezujonathan.blogs.repository.interfaces.IBlogRepository;
import bootcamp.bendezujonathan.blogs.service.interfaces.IBlogService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService {

    private final IBlogRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public EntradaDeBlogResponse create(EntradaDeBlogRequest request) {
        EntradaDeBlog toCreate = this.mapper.convertValue(request, EntradaDeBlog.class);
        if (this.repository.exists(toCreate))
            throw new BlogNoCreatedException(String.format("Blog with ID [%d] already exists", toCreate.getId()));
        toCreate.setFechaPublicacion(LocalDate.now().toString());
        this.repository.save(toCreate);

        return EntradaDeBlogResponse.builder()
                .id(toCreate.getId())
                .build();
    }

    @Override
    public List<EntradaDeBlogResponse> findAll() {
        return this.repository
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public EntradaDeBlogResponse searchById(int id) {
        return this.repository
                .findAll()
                .stream()
                .filter(blog -> blog.getId() == id)
                .findFirst()
                .map(this::toResponse)
                .orElseThrow(() -> new NotFoundException(String.format("No blog was found for ID [%d]", id)));
    }

    private EntradaDeBlogResponse toResponse(EntradaDeBlog model) {
        return this.mapper.convertValue(model, EntradaDeBlogResponse.class);
    }

}
