package bootcamp.base.miniseries.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.base.miniseries.dto.response.MiniSerieResponse;

@RequestMapping("/mini-serie")
public interface IMiniSerieController {

    @GetMapping
    ResponseEntity<List<MiniSerieResponse>> findAll();


    @GetMapping("/{id}")
    ResponseEntity<MiniSerieResponse> findById(@PathVariable long id);

}
