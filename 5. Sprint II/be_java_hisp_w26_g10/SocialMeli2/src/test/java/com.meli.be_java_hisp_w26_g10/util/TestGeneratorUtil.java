package com.meli.be_java_hisp_w26_g10.util;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.exception.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Arrays;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Product;

import java.time.LocalDate;

import com.api.socialmeli.dto.UserDto;
import java.util.Collections;

public class TestGeneratorUtil {
    public static String orderAsc = "name_asc";
    public static String orderDesc = "name_desc";
    private static List<Buyer> buyers = loadData();
    public static List<Buyer> loadData(){
        List<Buyer> buyers = new ArrayList<>();
        String route = "classpath:buyer.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(route);

            Buyer[] buyersArray = objectMapper.readValue(file, Buyer[].class);

            for (Buyer b : buyersArray) {
                buyers.add(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return buyers;
    }

    public static Buyer getSingleBuyer() {
        List<Seller> sellerList = new ArrayList<>();
        Seller seller1 = new Seller(1, "Luis");

        sellerList.add(seller1);

        Buyer myBuyer = new Buyer(1, "Luis", sellerList);
        return myBuyer;
    }

    public static Buyer getBuyerById(Integer id) {
        Buyer buyer = buyers.stream().filter(
                b -> b.getUser_id().equals(id)).findFirst().orElse(null);
        //Valida que sea un usario registrado y retorna el cliente
        if (buyer == null) throw new NotFoundException("El usuario no existe o no se encuentra registrado.");
        return buyer;
    }

    public static List<Seller> OrderFollowedListByName(String order, List<Seller> sellers){
        //Ordenamiento ascendente mediante expresiones lambda
        if (order.equals(orderAsc)){
            return ((sellers.stream()
                    .sorted(Comparator.comparing(Seller::getUser_name)).toList()));
        }
        //Ordenamiento descendente mediante expresiones lambda
        if (order.equals(orderDesc)){
            return ((sellers.stream()
                    .sorted(Comparator.comparing(Seller::getUser_name).reversed()).toList()));
        }
        //Si no se encuentra el ordenamiento solicitado en el US0008 entonces lanza la excepción BadRequest
        throw new BadRequestException("Parametros incorrectos para el ordenamiento");
    }


    public static List<Post> postListOrderDesTest() {
        return postListOrderTestOutOrder();
    }

    public static List<Post> postListOrderAscTest() {
        List<Post> postList = postListOrderTestOutOrder();
        Collections.reverse(postList);
        return postList;
    }

    public static Buyer buyersPostListOrderTest() {
        return new Buyer(10, "Warren Buffett,",
                List.of(new Seller(1,"Jeff Bezos"),
                        new Seller(2,"Steve Jobs")
                ));
    }

    public static Buyer buyersWithoutSellers() {
        return new Buyer(10, "Warren Buffett",
                new ArrayList<>());

    }

    public static Buyer buyersWithSellersWithoutPost() {
        return new Buyer(10, "Isabel Medina",
                List.of(new Seller(180,"Camilo Vazquez")));

    }


    private static List<Product> productsPostListOrderTest() {
        return  List.of(
                new Product(1, "Smartphone Galaxy S21", "Samsung", "Electrónico",
                        "Negro", "Nuevo en caja"),
                new Product(2, "Portátil MacBook Air", "Apple", "Electrónico",
                        "Gris", "Usado en excelente estado"),
                new Product(3, "Zapatillas Running UltraBoost 21", "Adidas", "Calzado",
                        "Blanco", "Con tecnología Boost"),
                new Product(4, "Cámara Mirrorless EOS R5", "Canon", "Fotografía",
                        "Negro", "Grabación 8K"),
                new Product(5, "Smartphone Galaxy S21", "Samsung", "Electrónico",
                        "Negro", "Nuevo en caja"));
    }

    public static List<Post> postListOrderTestOutOrder(){
        return Arrays.asList(
                new Post(1, LocalDate.now().minusDays(0), 1, 1500000.0, 1,
                        productsPostListOrderTest().get(0), false, 0.0),
                new Post(2, LocalDate.now().minusDays(1),  1, 3200000.0, 1,
                        productsPostListOrderTest().get(1), false, 0.0),
                new Post(3, LocalDate.now().minusDays(2),  1, 1800000.0, 1,
                        productsPostListOrderTest().get(2), false, 0.0),
                new Post(4, LocalDate.now().minusDays(3),  1, 2500000.0, 1,
                        productsPostListOrderTest().get(3), false, 0.0),
                new Post(5, LocalDate.now().minusDays(4),  2, 800000.0, 2,
                        productsPostListOrderTest().get(4), false, 0.0));
    }

    public static List<Post> postList(){
        return Arrays.asList(
                new Post(1, LocalDate.now().minusDays(0), 1, 1500000.0, 1,
                        productsPostListOrderTest().get(0), false, 0.0),
                new Post(2, LocalDate.now().minusDays(1),  1, 3200000.0, 1,
                        productsPostListOrderTest().get(1), false, 0.0),
                new Post(3, LocalDate.now().minusDays(30),  1, 1800000.0, 1,
                        productsPostListOrderTest().get(2), false, 0.0),
                new Post(4, LocalDate.now().minusDays(20),  1, 2500000.0, 1,
                        productsPostListOrderTest().get(3), false, 0.0),
                new Post(5, LocalDate.now().minusDays(90),  2, 800000.0, 2,
                        productsPostListOrderTest().get(4), false, 0.0));
    }


    public static List<Buyer> createBuyerEnvironment(){
        Buyer buyerOne = new Buyer(1,"Miguel Guzman",List.of(new Seller(1,"Meli"),new Seller(2,"Adidas"),new Seller(3,"Levis")));
        Buyer buyerTwo = new Buyer(2,"Juan Perez",List.of(new Seller(1,"Meli")));
        return List.of(buyerOne,buyerTwo);
    }
    public static List<Seller> createSellerEnvironment(){
        return List.of(new Seller(1,"Meli"), new Seller(2,"Adidas"),new Seller(3,"Levis"));
    }

    public static List<Buyer> generateBuyerList(){
        return new ArrayList<>(
                List.of(
                        new Buyer(1, "Antonio", Collections.emptyList()),
                        new Buyer(2, "Cesar", Collections.emptyList()),
                        new Buyer(3, "Jorge", Collections.emptyList()),
                        new Buyer(4, "Octavio", Collections.emptyList()),
                        new Buyer(5, "Zapata", Collections.emptyList())
                )
        );
    }

    public static List<UserDto> generateUserDtoList(){
        return new ArrayList<>(
                List.of(
                        new UserDto(
                                3,
                                "Zapata"
                        ),
                        new UserDto(
                                1,
                                "Antonio"
                        ),
                        new UserDto(
                                2,
                                "Octavio"
                        ),
                        new UserDto(
                                4,
                                "Cesar"
                        )
                )
        );
    }
}

