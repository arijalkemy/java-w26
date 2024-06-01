package bootcamp.bd.clothes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bd.clothes.dto.ClotheDto;
import bootcamp.bd.clothes.service.ClotheService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clothes")
@RequiredArgsConstructor
public class ClotheController {

    private final ClotheService clotheService;

    @GetMapping
    public ResponseEntity<List<ClotheDto>> getAll(){
        return ResponseEntity.ok(
            clotheService.searchAll()
        );
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody ClotheDto clotheDto){
        clotheService.create(clotheDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modify/{code}")
    public ResponseEntity<Void> update(@RequestBody ClotheDto clotheDto, @PathVariable("code") Integer code){
        clotheService.modify(clotheDto, code);
        return ResponseEntity.ok().build();
    }
}
