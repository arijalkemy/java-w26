package App.controllers;


import App.dto.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import App.services.IBlogService;

@RestController
class BlogController {

    @Autowired
    IBlogService service;

    @GetMapping("pong")
    public ResponseEntity<String> getPong(){
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<BlogDto> postPost(@RequestBody BlogDto blog){
        return service.addPost(blog);
    }


}
