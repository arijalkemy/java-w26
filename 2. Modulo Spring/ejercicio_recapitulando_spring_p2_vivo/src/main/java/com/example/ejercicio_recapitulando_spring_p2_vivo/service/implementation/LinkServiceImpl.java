package com.example.ejercicio_recapitulando_spring_p2_vivo.service.implementation;

import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkRequestDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkResponseDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.LinkDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.entity.Link;
import com.example.ejercicio_recapitulando_spring_p2_vivo.exception.BadRequestException;
import com.example.ejercicio_recapitulando_spring_p2_vivo.exception.NotFoundException;
import com.example.ejercicio_recapitulando_spring_p2_vivo.repository.ILinkRepository;
import com.example.ejercicio_recapitulando_spring_p2_vivo.service.ILinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {
    private final ILinkRepository linkRepository;

    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public CreateLinkResponseDto createLink(CreateLinkRequestDto createLinkRequestDto) {
        ObjectMapper mapper = new ObjectMapper();

        Link link = linkRepository.save(
            mapper.convertValue(createLinkRequestDto, Link.class)
        );

        System.out.println(link.toString());

        return mapper.convertValue(link, CreateLinkResponseDto.class);
    }

    @Override
    public LinkDto redirect(Integer linkId) {
        Optional<Link> link = linkRepository.findLinkById(linkId);

        if(link.isPresent()) {
            link.get().setCount(link.get().getCount() + 1);

            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(link.get(), LinkDto.class);
        } else {
            throw new NotFoundException("No se encontró el link.");
        }
    }

    @Override
    public LinkDto redirect(Integer linkId, String password) {
        Optional<Link> link = linkRepository.findLinkById(linkId);

        if(link.isPresent()) {
            if(!link.get().getPassword().equals(password)) {
                throw new BadRequestException("La contraseña es inválida.");
            } else {
                link.get().setCount(link.get().getCount() + 1);

                ObjectMapper mapper = new ObjectMapper();
                return mapper.convertValue(link.get(), LinkDto.class);
            }
        } else {
            throw new NotFoundException("No se encontró el link.");
        }
    }

    @Override
    public int getMetrics(Integer linkId) {
        Optional<Link> link = linkRepository.findLinkById(linkId);

        if(link.isPresent()) {
            return link.get().getCount();
        } else {
            throw new NotFoundException("No se encontró el link.");
        }
    }

    @Override
    public void invalidate(Integer linkId) {
        Optional<Link> link = linkRepository.findLinkById(linkId);

        if(link.isPresent()) {
            linkRepository.delete(link.get());
        } else {
            throw new NotFoundException("No se encontró el link.");
        }
    }
}
