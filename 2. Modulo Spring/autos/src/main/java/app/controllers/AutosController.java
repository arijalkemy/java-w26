package app.controllers;

import app.services.IAutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AutosController {

    @Autowired
    IAutosService service;

    //Set controller mappers


}
