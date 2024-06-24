package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.Post;

import java.util.List;

public interface IPostRepository {

    List<Post> getAll();

    void create(Post post);
    List<Post> getPostBy(int userId);
}
