package com.example.demo.Athletes.Adapter.in.web;

import com.example.demo.Athletes.Application.in.request.IPersonService;
import com.example.demo.Athletes.Application.out.response.PersonSportResponse;
import com.example.demo.Common.CustomAnnotations.LogExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final IPersonService personService;

    @GetMapping("/findPersons")
    @LogExecution
    public ResponseEntity<?> getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/findPersons/{name}")
    @LogExecution
    public ResponseEntity<?> getPersonByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(personService.findByName(name));
    }
    @GetMapping("/findBySport/{sport}")
    @LogExecution
    public ResponseEntity<List<PersonSportResponse>> getPersonsBySport(@PathVariable(
            "sport") String sportName) {
        return ResponseEntity.ok(personService.findBySport(sportName));
    }

}
