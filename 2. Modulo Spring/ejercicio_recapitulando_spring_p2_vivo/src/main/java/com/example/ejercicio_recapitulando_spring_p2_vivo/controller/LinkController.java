package com.example.ejercicio_recapitulando_spring_p2_vivo.controller;

import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkRequestDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkResponseDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.LinkDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.ResponseDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("")
    public ResponseEntity<CreateLinkResponseDto> createLink(
        @RequestBody CreateLinkRequestDto createLinkRequestDto
        ) {
        return new ResponseEntity<>(
            linkService.createLink(createLinkRequestDto),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{linkId}")
    public void redirect(
        @PathVariable Integer linkId,
        HttpServletResponse response
    ) throws IOException {
        LinkDto link = linkService.redirect(linkId);
        response.sendRedirect(link.getLink());
    }

    @GetMapping(value = "/{linkId}", params = {"password"})
    public void redirectWithPassword(
        @PathVariable Integer linkId,
        @RequestParam String password,
        HttpServletResponse response
    ) throws IOException {
        LinkDto link = linkService.redirect(linkId, password);
        response.sendRedirect(link.getLink());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<ResponseDto> metrics(
        @PathVariable Integer linkId
    ) {
        return new ResponseEntity<>(
            new ResponseDto("La cantidad de veces que se redireccionó fueron: " + linkService.getMetrics(linkId)),
            HttpStatus.OK
        );
    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseDto> invalidate(
        @PathVariable Integer linkId
    ) {
        linkService.invalidate(linkId);
        return new ResponseEntity<>(
            new ResponseDto("Link invalidad con éxito."),
            HttpStatus.OK
        );
    }
}
