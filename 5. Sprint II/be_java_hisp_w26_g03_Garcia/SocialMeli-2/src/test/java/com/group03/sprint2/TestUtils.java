package com.group03.sprint2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.entity.*;
import com.group03.sprint2.dto.response.UserDataResponseDTO;
import com.group03.sprint2.entity.Buyer;
import com.group03.sprint2.entity.Publication;
import com.group03.sprint2.entity.Seller;
import com.group03.sprint2.entity.UserData;
import com.group03.sprint2.utils.Utils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestUtils {
    public static Buyer createBuyer(Integer id) {
        return Buyer.builder()
                .userId(id)
                .userName("Buyer " + id)
                .followed(new ArrayList<>())
                .build();
    }
    public static Seller createSeller(Integer id) {
        return Seller.builder()
                .userId(id)
                .userName("Buyer " + id)
                .followers(new ArrayList<>())
                .build();
    }

    public static Seller createSeller(String name, Integer id, List<UserData> followers, List<Publication> publications) {
        return Seller.builder()
                .userId(id)
                .userName(name)
                .followers(followers)
                .publications(publications)
                .build();
    }

    public static List<Seller> loadSellersTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        File file = ResourceUtils.getFile("./src/test/resources/seller.json");
        return objectMapper.readValue(file, new TypeReference<List<Seller>>() {});
    }

    public static List<Buyer> loadBuyersTest() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Buyer> buyersList;

        file= ResourceUtils.getFile("./src/test/resources/buyer.json");
        buyersList= objectMapper.readValue(file,new TypeReference<List<Buyer>>(){});

        return buyersList;
    }

    public static List<Seller> loadSellersMain() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        File file = ResourceUtils.getFile("./src/main/resources/seller.json");
        return objectMapper.readValue(file, new TypeReference<List<Seller>>() {});
    }

    public static List<Buyer> loadBuyersMain() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Buyer> buyersList;

        file= ResourceUtils.getFile("./src/main/resources/buyer.json");
        buyersList= objectMapper.readValue(file,new TypeReference<List<Buyer>>(){});

        return buyersList;
    }

    public static List<Publication> getPublications(Integer userId) throws IOException {
        List<Seller> listSeller = loadSellersTest();
        return Objects.requireNonNull(listSeller.stream().filter(s -> s.getUserId().equals(userId))
                        .findFirst().orElse(null))
                .getPublications();
    }

    public static List<PublicationDTO> getPublicationDTOs(Integer userId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return getPublications(userId).stream()
                .map(publication -> objectMapper.convertValue(publication, PublicationDTO.class)).toList();
    }

    public static List<PublicationDTO> getPublicationDTOsFromLastTwoWeeks(Integer userId) throws IOException {
        List<PublicationDTO> publications = getPublicationDTOs(userId);
        publications.forEach(p -> p.setDate(LocalDate.now()));
        return publications;
    }

    public static List<UserData> getFollowedByBuyerId(Integer userId) throws IOException {
        List<Buyer> listBuyers = loadBuyersTest();
        Buyer buyer = listBuyers.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst().orElse(null);
        if (Utils.isNotNull(buyer)) {
            return buyer.getFollowed();
        }
        return null;
    }

    public static Seller getSellerById(Integer id) throws IOException {
        List<Seller> listSeller = loadSellersTest();
        return listSeller.stream().filter(s -> s.getUserId().equals(id)).findFirst().orElse(null);
    }

    public static List<PublicationDTO> getPublicationDTOsFromLastTwoWeeksOrderedByDate(boolean ascending, List<PublicationDTO> publications) throws IOException {
        if (ascending){
            return publications.stream()
                    .sorted(Comparator.comparing(PublicationDTO::getDate))
                    .collect(Collectors.toList());
        }
        return publications.stream()
                .sorted(Comparator.comparing(PublicationDTO::getDate).reversed())
                .collect(Collectors.toList());
    }

    public static List<Publication> getPublicationFromLastTwoWeeksOrderedByDate(boolean ascending, List<Publication> publications) throws IOException {
        if (ascending){
            return publications.stream()
                    .sorted(Comparator.comparing(Publication::getDate))
                    .collect(Collectors.toList());
        }
        return publications.stream()
                .sorted(Comparator.comparing(Publication::getDate).reversed())
                .collect(Collectors.toList());
    }

    public static Publication createPublicationBySellerId(Integer sellerId){
        Product product = new Product(765, "PS5", "Consola", "Sony", "Blanca", "Nueva");
        return Publication.builder()
                .postId(2)
                .userId(sellerId)
                .date(LocalDate.now())
                .product(product)
                .category(100)
                .price(700000.0)
                .build();
    }

    public static List<PublicationDTO> getExpectedPublications(Seller seller, boolean ascending) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Publication> publicationListSeller = seller.getPublications();
        publicationListSeller.get(0).setDate(LocalDate.now().minusDays(1));
        //agrego una publicacion para poder hacer el ordenamiento
        publicationListSeller.add(createPublicationBySellerId(seller.getUserId()));
        seller.setPublications(publicationListSeller);
        List<PublicationDTO> publicationDTOList = seller.getPublications().stream()
                .map(p -> mapper.convertValue(p, PublicationDTO.class))
                .collect(Collectors.toList());

        List<PublicationDTO> expectedPublications = TestUtils
                .getPublicationDTOsFromLastTwoWeeksOrderedByDate(ascending, publicationDTOList);

        return expectedPublications;
    }

    public static Buyer getBuyerById(Integer id) throws IOException {
        List<Buyer> listBuyer = loadBuyersTest();
        return listBuyer.stream().filter(buyer -> buyer.getUserId().equals(id)).findFirst().orElse(null);
    }

    public static List<UserDataResponseDTO> getFollowedDTOByBuyerId(Integer userId) throws IOException {
        List<Buyer> listBuyers = loadBuyersTest();
        ObjectMapper objectMapper = new ObjectMapper();
        Buyer buyer = listBuyers.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst().orElse(null);
        if (Utils.isNotNull(buyer)) {
            return buyer.getFollowed().stream().map(f -> objectMapper.convertValue(f, UserDataResponseDTO.class)).toList();
        }
        return null;
    }

    public static List<UserDataResponseDTO> getFollowersDTOBySellerId(Integer userId) throws IOException {
        List<Seller> listSeller = loadSellersTest();
        ObjectMapper objectMapper = new ObjectMapper();
        Seller seller = listSeller.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
        if (Utils.isNotNull(seller)) {
            return seller.getFollowers().stream().map(f -> objectMapper.convertValue(f, UserDataResponseDTO.class)).toList();
        }
        return null;
    }

}
