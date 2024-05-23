package com.tests.cases.controller;

import com.tests.cases.dto.TestCasesDto;
import com.tests.cases.service.ITestCasesService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {
    @Autowired
    ITestCasesService testCasesService;

    /**
     *
     * @param testCasesDto: json que trae los datos a almacenar
     * @return retorna el objeto creado
     */
    @PostMapping("/new")
    public ResponseEntity<?> saveTest(@RequestBody TestCasesDto testCasesDto){
        return new ResponseEntity<>(this.testCasesService.saveTest(testCasesDto), HttpStatus.CREATED);
    }

    /**
     *
     * @return retorna la lista de objetos
     */
    @GetMapping
    public ResponseEntity<?> getAllTest(){
        return new ResponseEntity<>(this.testCasesService.getAllTest(), HttpStatus.OK);
    }

    /**
     *
     * @return retorna la lista de objetos
     */
    @GetMapping("/id")
    public ResponseEntity<?> getTestById(@RequestParam Long id){
        return new ResponseEntity<>(this.testCasesService.getTestCasesById(id), HttpStatus.OK);
    }

    /**
     *
     * @param id : Identificador del test
     * @param testCasesDto : json de datos a almacenar
     * @return retorna la objeto modificado
     */
    @PutMapping("/id")
    public ResponseEntity<?> changeTestCase(@RequestParam Long id, @RequestBody TestCasesDto testCasesDto){
        return new ResponseEntity<>(this.testCasesService.changeTest(id, testCasesDto), HttpStatus.ACCEPTED);
    }

    /**
     *
     * @param id : Identificador del test
     * @return retorna una cadena indicando el estado
     */
    @DeleteMapping("/id")
    public ResponseEntity<?> deleteTestCase(@RequestParam Long id){
        return new ResponseEntity<>(this.testCasesService.deleteTest(id), HttpStatus.OK);
    }

    /**
     *
     * @return retorna una cadena indicando el estado
     */
    @GetMapping("/filter")
    public ResponseEntity<?> filterTests(@RequestParam (required = false) boolean tested, @RequestParam (required = false) boolean passed, @RequestParam (required = false) Integer number_of_tries, @RequestParam (required = false) LocalDate last_update){
        return new ResponseEntity<>(this.testCasesService.filterTests(tested, passed, number_of_tries, last_update), HttpStatus.OK);
    }
}
