package org.example.linktracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.linktracker.dto.IdLinkDTO;
import org.example.linktracker.dto.LinkDTO;
import org.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.io.IOException;

@RestController
public class LinkController {

    /*
    Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el linkId para utilizar en la redirección.
    Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL enmascarada.
        Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver 404(INVESTIGAR REDIRECT).
    Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} )
        tiene que devolver la estadística de cantidad de veces que se redireccionó.
    Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).
    Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.
    */
    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<IdLinkDTO> createLink(@RequestBody String url, @RequestParam(required = false) String password) {
        if (password == null) {
            return new ResponseEntity<>(linkService.create(url), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(linkService.create(url, password), HttpStatus.CREATED);
        }
    }

    @GetMapping("/link/{id}")
    public void redirectLink(@PathVariable String id, HttpServletResponse response) throws IOException {
        linkService.redirect(id, response);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDTO> getMetricsRedirect(@PathVariable String id) {
        return new ResponseEntity<>(linkService.getCantRedirects(id), HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{id}")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable String id) {
        return new ResponseEntity<>(linkService.invalidateLink(id), HttpStatus.OK);
    }




}
