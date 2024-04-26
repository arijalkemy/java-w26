package org.example.linktracer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.linktracer.dto.LinkMetricsDto;
import org.example.linktracer.dto.LinkResponseDto;
import org.example.linktracer.exception.BadRequestException;
import org.example.linktracer.exception.NotFoundException;
import org.example.linktracer.repository.ILinkRepository;
import org.example.linktracer.repository.LinkRespositoryImplementation;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImplementation implements ILinkService{

    ILinkRepository repository;
    ObjectMapper mapper;
    LinkServiceImplementation(LinkRespositoryImplementation _repository){
        repository = _repository;
        mapper = new ObjectMapper();
    }


    @Override
    public LinkResponseDto generateLink(String password) {
        return mapper.convertValue(repository.generateLinkId(password), LinkResponseDto.class);
    }

    @Override
    public String invalidateLink(String linkId) {

        idValidator(linkId);

        return repository.invalidateLink(linkId);
    }

    @Override
    public LinkMetricsDto getMetrics(String linkId) {

        idValidator(linkId);

        return mapper.convertValue(repository.getMetrics(linkId), LinkMetricsDto.class);
    }

    @Override
    public String redirect(String linkId) {

        if(!isValidUUID(linkId))
        {
            throw new BadRequestException("Invalid link id");
        }

        if(!repository.validateLink(linkId))
            throw new NotFoundException("INVESTIGAR REDIRECT");
        repository.incrementLinkCounter(linkId);
        return "http://localhost:8080/link/" + linkId;
    }

    private void idValidator(String linkId) {
        if(!isValidUUID(linkId) || !repository.validateLink(linkId))
        {
            throw new BadRequestException("Invalid link id");
        }
    }

    private boolean isValidUUID(String uuid)
    {
        // Expresión regular para validar UUID
        String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un matcher con el String dado
        Matcher matcher = pattern.matcher(uuid);

        // Verificar si el matcher encuentra una coincidencia
        return matcher.matches();
    }
}
