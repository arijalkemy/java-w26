package com.codigoMorse.demo.controller;


import com.codigoMorse.demo.services.ITraductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traductor")
public class TraductorController {
    @Autowired
    ITraductorService traductorService;

   @GetMapping("/espaniol/{morse}")
    public String morseAEspniol(@PathVariable String morse) {
       return traductorService.morseAEspaniol(morse);
   }

   @GetMapping("/morse/{espaniol}")
    public String morseAEspaniol(@PathVariable String espaniol) {
       return traductorService.esoaniolAMorse(espaniol);
   }

}
