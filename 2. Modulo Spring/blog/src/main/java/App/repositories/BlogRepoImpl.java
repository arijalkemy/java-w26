package App.repositories;

import App.dto.BlogDto;
import App.entity.BlogEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepoImpl implements IBlogRepo {

    HashMap<Integer, BlogEntity> repo;

    BlogRepoImpl(){
        repo = new HashMap<>();
    }

    @Override
    public BlogEntity addToRepo(BlogEntity blog) {
        repo.put(blog.getId(), blog);
        return repo.get(blog.getId());
    }

    public Boolean isThereId(Integer id){
        return !repo.containsKey(id);
    }
    //Set repo logic
}
