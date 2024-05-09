package org.example.be_java_hisp_w26_g04.repository.seller;


import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.util.crud.ICRUD;

import java.util.List;

public interface ISellerRepository extends ICRUD<Seller> {
    List<Post> getPosts();
}
