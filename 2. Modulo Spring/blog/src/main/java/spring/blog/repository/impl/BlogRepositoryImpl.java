package spring.blog.repository.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import spring.blog.dto.BlogDto;
import spring.blog.entity.EntradaBlog;
import spring.blog.repository.IBlogRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class BlogRepositoryImpl implements IBlogRepository {
    private Map<Integer, EntradaBlog> blogDTOList;

    public BlogRepositoryImpl() {
        this.blogDTOList = new HashMap<>();
    }

    public boolean guardarEntradaBlog(EntradaBlog entradaBlog) {
        if (this.blogDTOList.containsKey(entradaBlog.getId())) {
            return false;
        }
        this.blogDTOList.put(entradaBlog.getId(), entradaBlog);
        return true;
    }

}
