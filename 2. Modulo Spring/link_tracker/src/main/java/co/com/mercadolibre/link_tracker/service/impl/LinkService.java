package co.com.mercadolibre.link_tracker.service.impl;

import co.com.mercadolibre.link_tracker.dto.LinkDto;
import co.com.mercadolibre.link_tracker.entity.Link;
import co.com.mercadolibre.link_tracker.repository.ILinkRepository;
import co.com.mercadolibre.link_tracker.service.ILinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDto create(LinkDto linkDto) {
        ObjectMapper mapper = new ObjectMapper();
        linkRepository.save(mapper.convertValue(linkDto, Link.class));
        return linkDto;
    }

    @Override
    public LinkDto redirect(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> optionalLink = linkRepository.findById(id);
        if (optionalLink.isPresent()) {
            sumMetrics(mapper.convertValue(optionalLink.get(), LinkDto.class));
        }
        return null;
    }

    @Override
    public LinkDto redirect(Integer id, String password) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> optionalLink = linkRepository.findById(id);
        LinkDto linkDto = new LinkDto();
        if (optionalLink.isPresent()) {
            linkDto = checkLinkAndPassword(password, mapper.convertValue(optionalLink.get(), LinkDto.class));
        }
        return linkDto;
    }

    @Override
    public void invalidate(Integer id) {
        Optional<Link> optionalLink = linkRepository.findById(id);
        if (optionalLink.isPresent()) {
            linkRepository.invalidate(id);
        }
    }

    @Override
    public LinkDto metrics(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> optionalLink = linkRepository.findById(id);
        return mapper.convertValue(optionalLink.get(), LinkDto.class);
    }

    private void sumMetrics(LinkDto linkDto) {
        ObjectMapper mapper = new ObjectMapper();
        linkDto.sumCount();
        linkRepository.save(mapper.convertValue(linkDto, Link.class));
    }

    private LinkDto checkLinkAndPassword(String password, LinkDto linkDto) {
        LinkDto result = new LinkDto();
        if (linkDto.getPassword() != null && linkDto.getPassword().equals(password)){
            result = linkDto;
            sumMetrics(linkDto);
        }
        return result;
    }
}
