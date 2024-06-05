package org.example.be_java_hisp_w26_g07.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class PostDecorator extends Post{
    protected Post post;

    public PostDecorator(Post post){
        this.post = post;
    }
}
