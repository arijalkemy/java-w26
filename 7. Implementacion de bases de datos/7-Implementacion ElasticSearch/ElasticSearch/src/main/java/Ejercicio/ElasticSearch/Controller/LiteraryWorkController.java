package Ejercicio.ElasticSearch.Controller;

import Ejercicio.ElasticSearch.Dto.LiteraryWorkRequestDto;
import Ejercicio.ElasticSearch.Dto.LiteraryWorkResponseDto;
import Ejercicio.ElasticSearch.Entity.LiteraryWork;
import Ejercicio.ElasticSearch.Service.ILiteraryWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LiteraryWorkController {
    ILiteraryWorkService literaryWorkService;

    public LiteraryWorkController(ILiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @PostMapping("/create")
    public ResponseEntity<LiteraryWorkResponseDto> createLiteraryWork(@RequestBody LiteraryWorkRequestDto literaryWorkRequestDto) {
        LiteraryWorkResponseDto literaryWorkResponseDto = literaryWorkService.createLiteraryWork(literaryWorkRequestDto);
        return new ResponseEntity<>(literaryWorkResponseDto, HttpStatus.OK);
    }

    @GetMapping("/works/{author}")
    public List<LiteraryWork> getWorksByAuthor(@PathVariable String author) {
        return literaryWorkService.findByAuthor(author);
    }

}
