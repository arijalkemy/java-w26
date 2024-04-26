package App.services;

import App.dto.BlogDto;
import App.entity.BlogEntity;
import App.mapper.Mapper;
import App.repositories.IBlogRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
class BlogServiceImpl implements IBlogService {

    IBlogRepo repo;

    BlogServiceImpl(IBlogRepo repo){
        this.repo = repo;
    }

    @Override
    public ResponseEntity<BlogDto> addPost(BlogDto blogDto) {

        //data mapping
        BlogEntity blog = new BlogEntity(blogDto.getId(), blogDto.getTituloDelBlog(), blogDto.getNombreDelAutor(), blogDto.getDateTime());
        if (repo.isThereId(blog.getId())){
            BlogDto blogDtoResponse = Mapper.entityToDto(repo.addToRepo(blog));
            return new ResponseEntity<>(blogDtoResponse, HttpStatus.CREATED);
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El número ya existe como ID.");
        }


    }
    //Set Service method
}
