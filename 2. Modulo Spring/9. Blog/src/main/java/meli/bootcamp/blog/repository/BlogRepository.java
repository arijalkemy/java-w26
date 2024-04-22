package meli.bootcamp.blog.repository;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.blog.entity.Post;
import meli.bootcamp.blog.repository.interfaces.ICrud;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogRepository implements ICrud<Post> {

    private final List<Post> blog = new ArrayList<>();


    @Override
    public Post save(Post post) {
        blog.add(post);
        return post;
    }

    @Override
    public Post findById(Integer id) {
        return blog.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return blog;
    }
}
