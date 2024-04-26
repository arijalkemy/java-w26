package com.link.link.controller;

import com.link.link.dto.RequestBuscarUrlPorIdDTO;
import com.link.link.dto.RequestCrearUrlDTO;
import com.link.link.dto.ResponseCrearUrlDTO;
import com.link.link.exception.UrlNotFoundException;
import com.link.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController

@RequestMapping("/url")
public class LinkController {
    @Autowired
    ILinkService linkService;


    @PostMapping("/crearUrl")
    public ResponseEntity<?> crearUrl(@RequestBody RequestCrearUrlDTO request)
    {
        try
        {
            ResponseCrearUrlDTO respuesta = linkService.crearUrl(request);

            return new ResponseEntity<>(respuesta,HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("link/{id}")
    public ResponseEntity<?> buscarUrl(@PathVariable Long id)
    {
        RequestBuscarUrlPorIdDTO request = new RequestBuscarUrlPorIdDTO(id);
        HttpHeaders headers = new HttpHeaders();
        String url = linkService.buscarUrl(request);
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }


    @ExceptionHandler(UrlNotFoundException.class)
    public String handleUrlNotFoundException(UrlNotFoundException ex)
    {
        return ex.getMessage();
    }


}
