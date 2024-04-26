package org.example.sprint1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class SellerRepository implements ISellerRepository {
    private List<Seller> sellersList = new ArrayList<>();

    public SellerRepository() throws IOException {
        loadSellers();
    }

    private void loadSellers() throws IOException {
        File file = ResourceUtils.getFile("classpath:sellers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        sellersList.addAll(objectMapper.readValue(file, new TypeReference<List<Seller>>() {
        }));
    }

    public Seller filterSellerById(int id){
        return sellersList.stream().filter(seller -> seller.getSellerId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean productIdExists(int id) {
        return sellersList.stream()
                .anyMatch(seller -> seller.productIdExists(id));
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellersList;
    }

    @Override
    public Seller getSellerById(int id) {
        return sellersList.stream().filter(v -> v.getSellerId() == id ).findFirst().orElse(null);
    }

    public boolean postIdExist(int id){
        return sellersList.stream().anyMatch(seller -> seller.getPosts()
                .stream().anyMatch(post -> post.getPostId() == id));
    }

    @Override
    public boolean userIdToFollowSeller(int userId, int userIdToFollow) {

        //se busca el id
        Seller seller = sellersList.stream().filter(value -> value.getSellerId() == userIdToFollow)
                .findFirst().orElse(null);

        //regresa true si se encuentra id
        if(seller == null) return true;

        //se agrega id
        seller.addFollowers(userId);

        return false;

    }

    @Override
    public Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers) {
        List<Seller> sellersMatch = new ArrayList<>();
        Map<Integer, List<Post>> postsMatch = new HashMap<>();

        // Obtenemos cada seller que el customer sigue
        for (Integer sellerId : sellers) {
            sellersMatch.add(filterSellerById(sellerId));
        }

        // Agregamos a una lista todos los post que cumplen con las especificaciones
        for(Seller seller : sellersMatch) {
            postsMatch.put(
                    seller.getSellerId(),
                    findPostsWithTwoWeeksOld(seller.getPosts())
            );
        }

        // Ordenar la lista de posts por fecha de manera descendente
//        postsMatch.sort(Comparator.comparing(Post::getDate).reversed());

        return postsMatch;
    }

    private List<Post> findPostsWithTwoWeeksOld(List<Post> posts) {
        // Obtener la fecha de hace dos semanas y la actual
        LocalDate twoWeeksBefore = LocalDate.now().minusWeeks(2);
        LocalDate currentDate = LocalDate.now();

        // Retorna todos los post del seller que hayan sido publicados en las
        // últimas dos semanas
        return posts.stream()
                .filter(post ->
                    (post.getDate().isAfter(twoWeeksBefore) ||
                    post.getDate().isEqual(twoWeeksBefore)) &&
                    (post.getDate().isBefore(currentDate) ||
                    post.getDate().isEqual(currentDate))
                )
                .toList();
    }

    public List<Seller> getCustomersThatFollowsSellersById(int id) {
        return  sellersList.stream()
                .filter( v -> v.getFollowers().contains(id))
                .toList();
    }
}
