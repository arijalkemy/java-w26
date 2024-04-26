package com.group03.sprint1.service.implementation;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.dto.SellerFollowersDTO;
import com.group03.sprint1.dto.response.*;
import com.group03.sprint1.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;
import com.group03.sprint1.exception.entity.NotFoundException;
import com.group03.sprint1.exception.entity.BadRequestException;
import com.group03.sprint1.repository.IUsersRepository;
import com.group03.sprint1.repository.implementation.UsersRepositoryImpl;
import com.group03.sprint1.service.IUsersService;
import com.group03.sprint1.utils.Constants;
import com.group03.sprint1.utils.Utils;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsersServiceImpl implements IUsersService {

    private final IUsersRepository usersRepository;

    private ObjectMapper objectMapper;

    public UsersServiceImpl(UsersRepositoryImpl usersRepository) {
        this.usersRepository = usersRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public SellerFollowersDTO getFollowers(Integer userId) {
        // 1- Recorrer la lista con todos los sellers y filtrarlos por id
        Seller seller = usersRepository.findSellerById(userId);

        // 2- Veo el size de la lista BuyersFollowers para calcular la cantidad de seguidores del seller
        Integer numberOffollowers = seller.getFollowers().size();

        //Cargo el DTO para poder responder en el Controller

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        sellerFollowersDTO.setUserId(seller.getUserId());
        sellerFollowersDTO.setUsername(seller.getUserName());
        sellerFollowersDTO.setFollowers(numberOffollowers);
        return sellerFollowersDTO;

    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        Seller seller = usersRepository.findSellerById(userIdToFollow);
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }
        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userIdToFollow);
        }

        addFollowers(seller, buyer);
        usersRepository.follow(seller, buyer);
    }

    private void addFollowers(Seller seller, Buyer buyer) {
        List<UserData> lstSellers = buyer.getFollowed();
        UserData sellerAdd = lstSellers.stream().filter(u -> u.getUserId()
                .equals(seller.getUserId())).findFirst().orElse(null);
        List<UserData> lstBuyers = seller.getFollowers();
        UserData buyerAdd = lstBuyers.stream().filter(u -> u.getUserId()
                .equals(buyer.getUserId())).findFirst().orElse(null);

        if (sellerAdd != null || buyerAdd != null) {
            throw new BadRequestException("There is already a follower with ID: " + sellerAdd.getUserId());
        }

        lstBuyers.add(new UserData(buyer.getUserId(), buyer.getUserName()));
        seller.setFollowers(lstBuyers);
        lstSellers.add(new UserData(seller.getUserId(), seller.getUserName()));
        buyer.setFollowed(lstSellers);
    }


    public SellerResponseDTO showSellerFollowers(Integer userId, String order) {

        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNotNull(seller)) {

            if (Utils.isNotNull(order)) {
                if (order.equals(Constants.NAME_ASCENDANT)){
                    seller.setFollowers(orderByLetter(
                            seller.getFollowers(), Comparator.comparing(buyer -> buyer.getUserName())));
                }else if(order.equals(Constants.NAME_DESCENDANT)){
                    seller.setFollowers(orderByLetter(
                            seller.getFollowers(), Comparator.comparing(
                                    (UserData buyer) -> buyer.getUserName()).reversed()));
                }else{
                    throw new BadRequestException("Invalid parameter to order list: " + order);
                }
            }

            SellerResponseDTO sellerResponseDTO = new SellerResponseDTO(
                                                        seller.getUserId(),
                                                        seller.getUserName(),
                                                        seller.getFollowers().stream()
                                                                .map(ModelConversionService::convertToDTO)
                                                                .collect(Collectors.toList()), null);
            return sellerResponseDTO;

        } else {
            throw new BadRequestException("There is not seller with ID: " + userId);
        }
    }

    private class ModelConversionService {
        public static UserDataResponseDTO convertToDTO(UserData userData) {
            return new UserDataResponseDTO(userData.getUserId(), userData.getUserName());
        }
    }


    public BuyerResponseDTO showBuyerFollowed(Integer userId, String order) {
        
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }

        if (Utils.isNotNull(order)) {
            if (order.equals(Constants.NAME_ASCENDANT)){
                buyer.setFollowed(orderByLetter(
                        buyer.getFollowed(), Comparator.comparing(seller -> seller.getUserName())));
            }else if(order.equals(Constants.NAME_DESCENDANT)){
                buyer.setFollowed(orderByLetter(
                        buyer.getFollowed(), Comparator.comparing(
                                (UserData seller) -> seller.getUserName()).reversed()));
            }else{
                throw new BadRequestException("Invalid parameter to order list: " + order);
            }
        }

        BuyerResponseDTO buyerResponseDTO = objectMapper.convertValue(buyer, BuyerResponseDTO.class);

        return buyerResponseDTO;
    }

    private <T> List<T> orderByLetter(List<T> list, Comparator<? super T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnFollow) {
        Seller seller = usersRepository.findSellerById(userIdToUnFollow);
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }
        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userIdToUnFollow);
        }

        deleteFollowers(seller, buyer);
        usersRepository.unfollow(seller, buyer);
    }

    private void deleteFollowers(Seller seller, Buyer buyer) {
        List<UserData> lstBuyers = seller.getFollowers();
        UserData buyerDelete = lstBuyers.stream().filter(u -> u.getUserId()
                .equals(buyer.getUserId())).findFirst().orElse(null);
        List<UserData> lstSellers = buyer.getFollowed();
        UserData sellerDelete = lstSellers.stream().filter(u -> u.getUserId()
                .equals(seller.getUserId())).findFirst().orElse(null);

        if (Utils.isNull(buyerDelete) || Utils.isNull(sellerDelete)) {
            throw new BadRequestException("There is not a follower with ID: " + buyer.getUserId());
        }

        lstBuyers.remove(buyerDelete);
        seller.setFollowers(lstBuyers);
        lstSellers.remove(sellerDelete);
        buyer.setFollowed(lstSellers);

    }

    @Override
    public List<SellersWithPublicationDTO> showAllSellers() {
        List<Seller> sellers = usersRepository.findAllSellers();
        return sellers.stream().map(p -> objectMapper.convertValue(p, SellersWithPublicationDTO.class)).toList();
    }

    @Override
    public SellerDTO createPublication(PublicationDTO publicationDTO) {

        if(usersRepository.findSellerById(publicationDTO.getUserId()) == null) {
            throw new NotFoundException("There is not seller with ID: " + publicationDTO.getUserId());
        }

        Publication publication = objectMapper.convertValue(publicationDTO, Publication.class);

        if(Utils.isNull(publication)) {
            throw new BadRequestException("Request cannot be null");
        }

        Seller seller = usersRepository.createPublication(publication);
        return objectMapper.convertValue(seller, SellerDTO.class);
    }

    @Override
    public void createPromoPublication(PublicationDTO publicationDTO) {
        Boolean hasPromo = publicationDTO.getHasPromo();
        Double discount = publicationDTO.getDiscount();
        if (hasPromo == null || discount == null || !hasPromo){
            throw new BadRequestException("The product you are trying to post has no valid promotion.");
        }
        createPublication(publicationDTO);
    }

    @Override
    public SellerWithPromoCountDTO getPromoCountBySeller(Integer userId) {
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)){
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        Integer countPromo = (int) seller.getPublications().stream()
                .filter(p -> p.getHasPromo() != null && p.getHasPromo())
                .count();

        SellerWithPromoCountDTO sellerWithPromoCountDTO = new SellerWithPromoCountDTO(seller.getUserId(),
                                                                        seller.getUserName(),
                                                                        countPromo);

        return sellerWithPromoCountDTO;
    }

    @Override
    public SellerWithPromoListDTO getPromoListBySeller(Integer userId) {
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)){
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        List<Publication> listPromoFiltered = seller.getPublications().stream()
                .filter(p -> p.getHasPromo() != null && p.getHasPromo()).toList();

        List<PublicationDTO> listPromo = listPromoFiltered.stream()
                                        .map(p -> objectMapper.convertValue(p, PublicationDTO.class))
                                        .collect(Collectors.toList());

        SellerWithPromoListDTO sellerWithPromoListDTO = new SellerWithPromoListDTO(seller.getUserId(),
                seller.getUserName(),
                listPromo);

        return sellerWithPromoListDTO;
    }

    @Override
    public String deletePostOfSeller(Integer userId, Integer postId) {
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)){
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        List<Publication> publications = seller.getPublications();

        Publication publicationToDelete = publications.stream()
                                            .filter(p -> (p.getPostId()) == postId)
                                            .findFirst()
                                            .orElse(null);

        if (Utils.isNull(publicationToDelete)){
            throw new BadRequestException("There is no post with ID: " + postId);
        }

        publications.remove(publicationToDelete);

        return "Post with id: " + postId + " deleted succesfully.";
    }

    @Override
    public String updatePostOfSeller(Integer userId, Integer postId, PublicationDTO publicationDTO) {
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)){
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        List<Publication> publications = seller.getPublications();

        Integer publicationToUpdateIndex = publications.indexOf(publications.stream()
                .filter(p -> (p.getPostId()) == postId)
                .findFirst()
                .orElse(null));

        if (publicationToUpdateIndex == -1){
            throw new BadRequestException("There is no post with ID: " + postId);
        }

        Publication publication = objectMapper.convertValue(publicationDTO, Publication.class);

        publications.set(publicationToUpdateIndex, publication);


        return "Post with id: " + postId + " updated succesfully.";
    }

    @Override
    public List<BuyerResponseDTO> getListBuyers() {
        List<Buyer> buyersList = usersRepository.showBuyers();

        List<BuyerResponseDTO> buyerListResponse = buyersList.stream()
                                    .map(b -> objectMapper.convertValue(b, BuyerResponseDTO.class))
                                    .toList();
        return buyerListResponse;
    }


}
