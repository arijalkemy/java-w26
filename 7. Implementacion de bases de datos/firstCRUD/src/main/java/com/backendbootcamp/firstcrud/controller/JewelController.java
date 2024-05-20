package com.backendbootcamp.firstcrud.controller;

import com.backendbootcamp.firstcrud.model.Jewel;
import com.backendbootcamp.firstcrud.model.ResponseDto;
import com.backendbootcamp.firstcrud.service.IJewelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jewel")
public class JewelController {
    private final IJewelService jewelService;
    @PostMapping("/new")
    public ResponseDto saveNewJewel(@RequestBody Jewel newJewel){
      return  jewelService.saveJewel(newJewel);
    }

}
