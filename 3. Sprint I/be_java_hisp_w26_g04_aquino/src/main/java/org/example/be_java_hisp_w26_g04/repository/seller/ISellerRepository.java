package org.example.be_java_hisp_w26_g04.repository.seller;


import java.util.List;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.util.crud.ICRUD;

public interface ISellerRepository extends ICRUD<Seller> {
    Post save(Post post);
    List<Post> getPosts();
    List<Post> getPostsWithPromoBySellerId(int sellerId);
}
