package com.group03.sprint2.controller;

import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.ResponseIdPublicationsDTO;
import com.group03.sprint2.dto.response.SellersWithPublicationDTO;
import com.group03.sprint2.service.IPublicationsService;
import com.group03.sprint2.service.implementation.PublicationsServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
public class PublicationsController {

    private final IPublicationsService publicationsService;

    public PublicationsController(PublicationsServiceImpl publicationsService) {
        this.publicationsService = publicationsService;
    }

    /**
     * Obtiene todos los vendedores que tengan una publicacion creada.
     * @return Devuelve todos los vendedores con publicaciones que existan en la base de datos.
     */
    @GetMapping("/all")
    public ResponseEntity<List<SellersWithPublicationDTO>> getAllProducts() {
        return new ResponseEntity<>(publicationsService.showAllSellers(), HttpStatus.OK);
    }

    /**
     * Crea una nueva publicacion para un vendedor especifico, utilizando los datos proporcionados en PublicationDTO.
     * @param publication
     * @return Devuelve un mensaje de exito en el cuerpo de la respuesta.
     */
    @PostMapping("/post")
    public ResponseEntity<MessageResponseDTO> createPublication(@Valid @RequestBody PublicationDTO publication) {
        return new ResponseEntity<>(publicationsService.createPublication(publication), HttpStatus.CREATED);
    }

    /**
     * Obtiene un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas.
     * En el caso que reciba un order como query param, el resultado se ordenará de manera ascendente o descendente segun la fecha.
     * @param userId
     * @param order
     * @return Devuelve una lista de publicaciones de las ultimas dos semanas.
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseIdPublicationsDTO> getFollowedLastTwoWeeksPublications(@PathVariable @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                                                                         @RequestParam(required = false) String order) {

        ResponseIdPublicationsDTO responseTwoWeeksPublicationsDTO = new ResponseIdPublicationsDTO();

        List<PublicationDTO> publicationsDTOList = publicationsService.findFollowedLastTwoWeeksPublications(userId, order);

        responseTwoWeeksPublicationsDTO.setPublications(publicationsDTOList);
        responseTwoWeeksPublicationsDTO.setUserId(userId);

        return new ResponseEntity<>(responseTwoWeeksPublicationsDTO, HttpStatus.OK);
    }
}
