package App.repositories;

import App.dto.BlogDto;
import App.entity.BlogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBlogRepo {
    BlogEntity addToRepo(BlogEntity blog);
    Boolean isThereId(Integer id);
}
