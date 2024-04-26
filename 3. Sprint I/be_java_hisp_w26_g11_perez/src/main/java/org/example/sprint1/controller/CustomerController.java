package org.example.sprint1.controller;

import jakarta.validation.Valid;
import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.dto.SuccessMessageDTO;
import org.example.sprint1.dto.customer.CustomerDTO;
import org.example.sprint1.dto.customer.CustomerRequestDTO;
import org.example.sprint1.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }

   @GetMapping("/{userId}")
    public ResponseEntity<List<PostDTO>> getPostWithFavoriteCategories(@Valid @PathVariable Integer userId) {
       return new ResponseEntity<>(customerService.getPostWithFavoriteCategories(userId), HttpStatus.OK);
   }

   @PatchMapping("/{userId}")
    public ResponseEntity<SuccessMessageDTO> updateCustomerCategories(
            @PathVariable Integer userId,
            @Valid @RequestBody CustomerRequestDTO requestDTO
   ) {

       return new ResponseEntity<>(customerService.updateCustomerCategories(userId, requestDTO), HttpStatus.OK);
   }

}
