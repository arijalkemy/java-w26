package com.mercadolibre.pf_be_hisp_w26_t01_ditta.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ISectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class SectionController {

    private final ISectionService sectionService;
    private final AuthenticationService authenticationService;

    @PostMapping("/sections")
    public ResponseEntity<?> createNewSection(@RequestBody SectionRequestDTO sectionRequestDTO){
        String managerEmail = authenticationService.getLogMail();
        sectionService.save(sectionRequestDTO, managerEmail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sections")
    public ResponseEntity<?> getAllSection() {
        String managerEmail = authenticationService.getLogMail();
        return new ResponseEntity<>(sectionService.getAll(managerEmail), HttpStatusCode.valueOf(200));
    }

}
