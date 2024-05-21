package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perlas")
public class JoyaController {
    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping
    public String saveJoya(@RequestBody Joya joya) {
        return joyaService.saveJoya(joya);
    }

    @GetMapping
    public List<Joya> getJoyas() {
        return joyaService.getJoyas();
    }

    @DeleteMapping("/{id}")
    public String deleteJoya(@PathVariable Long id) {
        return joyaService.deleteJoya(id);
    }

    @PutMapping("/{id_modificar}")
    public String editJoya(@PathVariable Long id_modificar, @RequestBody Joya joya) {
        return joyaService.editJoya(id_modificar, joya);
    }

}
