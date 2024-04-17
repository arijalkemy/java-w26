package bootcamp.spring.ej_star_wars.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.websocket.server.PathParam;

public interface IController<T> {
    @GetMapping(params = "name")
    ResponseEntity<T> getByName(@PathParam("name") String name);
}
