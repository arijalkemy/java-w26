package org.example.linktracker.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.linktracker.dto.in.LinkRequestDto;
import org.example.linktracker.dto.out.LinkResponseDto;
import org.example.linktracker.dto.out.LinkWithMetricsResponseDto;
import org.example.linktracker.exception.BadRequestException;
import org.example.linktracker.exception.LinkNotFoundException;
import org.example.linktracker.model.Link;
import org.example.linktracker.repository.ILinkRepository;
import org.example.linktracker.util.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkResponseDto createLink(LinkRequestDto linkRequestDto) {

        try {
            new URL(linkRequestDto.getTargetUrl());
        }
        catch (MalformedURLException e) {
            throw new BadRequestException("La URL para la cual se quiere crer un Link no es válida");
        }

        Link newLink = new Link(
            RandomStringUtils.randomAlphabetic(10),
            linkRequestDto.getTargetUrl(),
            0,
            linkRequestDto.getPassword()
        );

        linkRepository.save(newLink);

        return LinkMapper.toDto(newLink);
    }

    @Override
    public String getTargetUrlForLinkId(String linkId) {

        Link link = linkRepository.findById(linkId)
            .orElseThrow(LinkNotFoundException::new);

        link.setHitCount(link.getHitCount() + 1);
        linkRepository.save(link);

        String linkWithPasswordParameter = link.getTargetUrl();

        if (StringUtils.isNotBlank(link.getPassword()))
            linkWithPasswordParameter += "?password=" + URLEncoder.encode(link.getPassword(), StandardCharsets.UTF_8);

        return linkWithPasswordParameter;
    }

    @Override
    public LinkWithMetricsResponseDto getLinkWithMetrics(String linkId) {

        return linkRepository.findById(linkId)
            .map(LinkMapper::toDtoWithMetrics)
            .orElseThrow(LinkNotFoundException::new);
    }

    @Override
    public void invalidateLink(String linkId) {

        linkRepository.findById(linkId).orElseThrow(LinkNotFoundException::new);

        linkRepository.delete(linkId);
    }
}
