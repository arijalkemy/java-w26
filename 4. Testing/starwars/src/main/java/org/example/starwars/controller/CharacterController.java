    package org.example.starwars.controller;

    import org.example.starwars.dto.CharacterDTO;
    import org.example.starwars.service.CharacterServiceService;
    import org.example.starwars.service.ICharacterService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    public class CharacterController {
        @Autowired
        private ICharacterService characterService;

        @GetMapping("/find")
        public ResponseEntity<List<CharacterDTO>> findAll(@RequestParam String name){
            return ResponseEntity.ok(characterService.getAllCharactersWithName(name));
        }

    }
