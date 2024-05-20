package bootcamp.bd.joyeria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bd.joyeria.model.Joya;
import bootcamp.bd.joyeria.service.JoyasService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    
    private final JoyasService joyasService;

    public JoyaController(JoyasService joyasService){
        this.joyasService = joyasService;
    }

    @GetMapping
    public ResponseEntity<List<Joya>> getAll() {
        return ResponseEntity.ok(joyasService.searchAll());
    }

    @PostMapping
    public ResponseEntity<Long> post(@RequestBody Joya joya) {
        return new ResponseEntity<>(joyasService.create(joya),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        joyasService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Joya> update(@PathVariable Long id, @RequestBody Joya joya) {
        return ResponseEntity.ok(joyasService.update(joya, id));
    }
}
