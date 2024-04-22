package bootcamp.linktracker.service;

import bootcamp.linktracker.dto.LinkDTO;
import bootcamp.linktracker.exceptions.LinkNotFoundException;
import bootcamp.linktracker.repository.LinkRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Data
@AllArgsConstructor
public class LinkServiceImpl implements ILinkService{
    @Autowired
    LinkRepositoryImpl linkRepository;

    @Override
    public LinkDTO createLink(String originalUrl, String password) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setOriginalUrl(originalUrl);
        linkDTO.setLinkId(generateLinkId());
        linkDTO.setRedirectCount(0);
        linkDTO.setValid(true);

        linkRepository.save(linkDTO);
        return linkDTO;
    }

    private int generateLinkId() {
        // Generate a random number between 1000 and 9999
        return new Random().nextInt(99) + 1;
    }

    @Override
    public String redirectLink(int linkId, String password) {
        LinkDTO linkDTO = linkRepository.findById(linkId);
        if(linkDTO != null && linkDTO.isValid()){
                //falta logica pass y verificacion
            linkDTO.setRedirectCount(linkDTO.getRedirectCount() + 1);
            linkRepository.save(linkDTO);
            return linkDTO.getOriginalUrl();
        }
        return null;
    }

    @Override
    public int getRedirectCount(int linkId) {
        LinkDTO linkDTO = linkRepository.findById(linkId);
        if (linkDTO != null && linkDTO.isValid()){
            return linkDTO.getRedirectCount();
        }
        return -1; //si no existe
    }

    @Override
    public void invalidateLink(Integer linkId) {
        LinkDTO linkDTO = linkRepository.findById(linkId);
        if(linkDTO != null){
            linkDTO.setValid(false);
            linkRepository.save(linkDTO);
        } else {
            throw new LinkNotFoundException("No se encuentra el link ID: " + linkId);
        }
    }
}
