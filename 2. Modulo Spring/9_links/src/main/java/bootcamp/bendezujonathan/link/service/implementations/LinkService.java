package bootcamp.bendezujonathan.link.service.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.link.dto.request.LinkRequest;
import bootcamp.bendezujonathan.link.dto.response.LinkResponse;
import bootcamp.bendezujonathan.link.exceptions.LinkNoCreatedException;
import bootcamp.bendezujonathan.link.exceptions.NotFoundException;
import bootcamp.bendezujonathan.link.model.Link;
import bootcamp.bendezujonathan.link.repository.interfaces.ILinkRepository;
import bootcamp.bendezujonathan.link.service.interfaces.ILinkService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinkService implements ILinkService {

    private final ILinkRepository repository;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Map<Integer, AtomicInteger> COUNTER = new HashMap<>();

    private static final String URL_REGEX = "^http?://(?:www\\.)?[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,})+(?:/[^\\s]*)?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    @Override
    public LinkResponse createLink(LinkRequest request) {
        if (!URL_PATTERN.matcher(request.getUrl()).matches())
            throw new LinkNoCreatedException("URL No Valida");

        Link toCreate = new Link(repository.getNextId(), request.getUrl(), true, request.getPassword());

        if (this.repository.exists(toCreate))
            throw new LinkNoCreatedException("La URL ya existia");

        this.repository.save(toCreate);
        COUNTER.put(toCreate.getId(), new AtomicInteger());
        return this.toResponse(toCreate);
    }

    @Override
    public LinkResponse searchById(int id) {
        Link model = this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Link no encontrado para el ID [%d]", id)));
        COUNTER.get(model.getId()).incrementAndGet();
        return this.toResponse(model);
    }

    @Override
    public void invalidateLink(int id) {
        Link model = this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Link no encontrado para el ID [%d]", id)));
        model.setValid(false);
        this.repository.update(model);
    }

    @Override
    public LinkResponse searchMetrics(int id) {
        Link founded = this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Link no encontrado para el ID [%d]", id)));

        int count = COUNTER.get(founded.getId())
                .get();
        return new LinkResponse(id, null, count);
    }

    @Override
    public List<LinkResponse> searchAll() {
        return this.repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private LinkResponse toResponse(Link model) {
        return MAPPER.convertValue(model, LinkResponse.class);
    }

}
