package com.primerproyecto.pruebaspring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Definir controlador con RestController
@RestController
public class PrimerControlador {

    //GetMapping indica que en un get la api debe devolver el resultado del metodo
    @GetMapping
    public String sayHello(){
        return "Hola Mundo";
    }

    //Ejemplo de como recibir parametros (a traves del path)
    @GetMapping("/{name}")
    public String getConParametros(@PathVariable String name){
        return "Hola Mundo soy: " + name;
    }
}
