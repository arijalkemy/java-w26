package App.services;

import App.dto.BlogDto;
import org.springframework.http.ResponseEntity;

public interface IBlogService {

     ResponseEntity<BlogDto> addPost(BlogDto blog);

}
