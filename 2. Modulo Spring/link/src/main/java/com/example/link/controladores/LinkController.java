package com.example.link.controladores;


import com.example.link.DTOs.LinkRequestDTO;
import com.example.link.DTOs.LinkResponseDTO;
import com.example.link.modelo.Link;
import com.example.link.servicios.interfaces.ILinkServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    ILinkServicio linkServicio;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> crearLink(@RequestBody LinkRequestDTO linkRequestDTO) {

        LinkResponseDTO linkResponseDTO = this.linkServicio.crearLink(linkRequestDTO);

        return new ResponseEntity<>(linkResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId) {

        return linkServicio.redirect(linkId);
    }
}
