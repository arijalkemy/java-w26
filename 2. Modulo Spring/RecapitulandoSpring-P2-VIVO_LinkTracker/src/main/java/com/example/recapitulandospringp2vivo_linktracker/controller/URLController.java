package com.example.recapitulandospringp2vivo_linktracker.controller;

import com.example.recapitulandospringp2vivo_linktracker.dto.URLdto;
import com.example.recapitulandospringp2vivo_linktracker.model.URL;
import com.example.recapitulandospringp2vivo_linktracker.service.IServiceURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping("/link")
public class URLController {

    @Autowired
    IServiceURL iServiceURL;

    @PostMapping
    public ResponseEntity<URLdto> addURL(@RequestBody URL url) {

        return new ResponseEntity<>(iServiceURL.addURL(url), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Map<String, URLdto>> getAll() {
        return new ResponseEntity<>(iServiceURL.getAllUrl(), HttpStatus.OK);
    }

    //manejar exception cuando el link no exista

    @GetMapping("/{linkId}")
    public RedirectView redirecTo(@PathVariable String linkId) {
        String path = iServiceURL.redirectURL(linkId);
        return new RedirectView(path);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> obtainNumberOfRedirects(@PathVariable String linkId) {
        return new ResponseEntity<>(iServiceURL.getNumberOfRedirects(linkId), HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateURL(@PathVariable String linkId){
        return new ResponseEntity<>(iServiceURL.invalidateURL(linkId), HttpStatus.OK);
    }

}
