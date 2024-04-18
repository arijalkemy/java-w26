package com.example.EjercicioCodigoMorse.Controller;

import com.example.EjercicioCodigoMorse.Service.IToWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class ToWordsController {
    @Autowired
    IToWordsService toWordsService;

    @GetMapping("/toAlfabetic/{text}")
    public String getAlfabetic(@PathVariable String text){
        return toWordsService.decode(text);
    }

    @GetMapping("/toMorse/{traduction}")
    public String getMorse(@PathVariable String traduction){
        return toWordsService.encode(traduction);
    }
}
