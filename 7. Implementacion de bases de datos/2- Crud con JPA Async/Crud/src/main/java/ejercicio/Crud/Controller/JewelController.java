package ejercicio.Crud.Controller;

import ejercicio.Crud.DTO.Request.JewelRequestDto;
import ejercicio.Crud.DTO.Response.JewelResponseDto;
import ejercicio.Crud.Service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {

    IJewelService jewelService;

    public JewelController(IJewelService jewelService) {

        this.jewelService = jewelService;
    }

    @PostMapping("save/jewel")
    public ResponseEntity<Long> saveJewel(@RequestBody JewelRequestDto jewelRequestDto){
        JewelResponseDto jewelResponseDto = jewelService.saveJewel(jewelRequestDto);
        return new ResponseEntity<>(jewelResponseDto.getId(), HttpStatus.CREATED);
    }

    @GetMapping("get/jewels")
    public ResponseEntity<JewelResponseDto> getAllJewells(){
        List <JewelResponseDto> jewelResponseDtoList = jewelService.getAllJewells();
        return new ResponseEntity(jewelResponseDtoList, HttpStatus.OK);


    }

    @DeleteMapping
    public ResponseEntity<?> deleteJewel(@RequestParam Long id){
        jewelService.deleteJewel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@RequestBody JewelRequestDto jewelDtoRequest, @RequestParam Long id){
        jewelService.updateJewel(jewelDtoRequest, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
