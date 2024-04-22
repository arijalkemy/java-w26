package bootcamp.spring.link_tracker.service.implementations;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.spring.link_tracker.dto.request.LinkDTOrequest;
import bootcamp.spring.link_tracker.dto.response.LinkDTOresponse;
import bootcamp.spring.link_tracker.exceptions.InvalidUrlFormatException;
import bootcamp.spring.link_tracker.model.Link;
import bootcamp.spring.link_tracker.repository.interfaces.ILinkRepository;
import bootcamp.spring.link_tracker.service.interfaces.ILinkService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    @Override
    public LinkDTOresponse save(LinkDTOrequest linkDto) {
        String regex = "^(https?|ftp|file|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linkDto.getUrl());
        
        if (!matcher.matches()) {
            throw new InvalidUrlFormatException("La url tiene un formato invalido");
        }

        ObjectMapper MAPPER = new ObjectMapper();
        Link link = MAPPER.convertValue(linkDto,Link.class );
        Integer id = linkRepository.save(link);
        return new LinkDTOresponse(id);
    }

    @Override
    public String searchUrlLinkById(Integer id) {
        Link link = linkRepository.findById(id);
        if(Objects.isNull(link)){
            return null;
        }
        linkRepository.sumRedirect(link);
        return link.getUrl();
    }

    @Override
    public Integer searchTimesRedirected(Integer id) {
        Link link = linkRepository.findById(id);
        if(Objects.isNull(link)){
            return -1;
        }
        return link.getVecesRedireccionado();

    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = linkRepository.findById(id);
        if(!Objects.isNull(link)){
            linkRepository.invalidateLink(id);
        }
    }   

	
}
