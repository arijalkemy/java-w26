package com.group03.sprint2.service.implementation;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.UserDataResponseDTO;
import com.group03.sprint2.entity.Seller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group03.sprint2.dto.response.SellerResponseDTO;
import com.group03.sprint2.entity.Buyer;
import com.group03.sprint2.exception.entity.BadRequestException;
import com.group03.sprint2.entity.UserData;
import com.group03.sprint2.dto.response.BuyerResponseDTO;
import com.group03.sprint2.repository.IUsersRepository;
import com.group03.sprint2.repository.implementation.UsersRepositoryImpl;
import com.group03.sprint2.service.IUsersService;
import com.group03.sprint2.utils.Constants;
import com.group03.sprint2.utils.Utils;
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
    public SellerNumberOfFollowersDTO getNumberOfFollowers(Integer userId) {
        // 1- Recorrer la lista con todos los sellers y filtrarlos por id
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        // 2- Veo el size de la lista BuyersFollowers para calcular la cantidad de seguidores del seller
        Integer numberOffollowers = seller.getFollowers().size();

        //Cargo el DTO para poder responder en el Controller
        SellerNumberOfFollowersDTO sellerNumberOfFollowersDTO = new SellerNumberOfFollowersDTO();
        sellerNumberOfFollowersDTO.setUserId(seller.getUserId());
        sellerNumberOfFollowersDTO.setUsername(seller.getUserName());
        sellerNumberOfFollowersDTO.setFollowers(numberOffollowers);
        return sellerNumberOfFollowersDTO;

    }

    @Override
    public MessageResponseDTO followUser(Integer userId, Integer userIdToFollow) {
        Seller seller = usersRepository.findSellerById(userIdToFollow);
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }
        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userIdToFollow);
        }

        addFollowers(seller, buyer);
//        usersRepository.follow(seller, buyer);
        return new MessageResponseDTO("Successfully followed user: " + userIdToFollow);
    }

    private void addFollowers(Seller seller, Buyer buyer) {
        List<UserData> lstSellers = buyer.getFollowed();
        UserData sellerAdd = lstSellers.stream().filter(u -> u.getUserId()
                .equals(seller.getUserId())).findFirst().orElse(null);
        List<UserData> lstBuyers = seller.getFollowers();
        UserData buyerAdd = lstBuyers.stream().filter(u -> u.getUserId()
                .equals(buyer.getUserId())).findFirst().orElse(null);

        if (Utils.isNotNull(sellerAdd) || Utils.isNotNull(buyerAdd)) {
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
                if (order.equals(Constants.ORDER_NAME_ASCENDANT)){
                    seller.setFollowers(orderByLetter(
                            seller.getFollowers(), Comparator.comparing(buyer -> buyer.getUserName())));
                }else if(order.equals(Constants.ORDER_NAME_DESCENDANT)){
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
        public static UserData convertToEntity(UserDataResponseDTO dto) {
            return new UserData(dto.getUserId(), dto.getUserName());
        }
    }

    public BuyerResponseDTO showBuyerFollowed(Integer userId, String order) {
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }

        if (Utils.isNotNull(order)) {
            if (order.equals(Constants.ORDER_NAME_ASCENDANT)){
                buyer.setFollowed(orderByLetter(
                        buyer.getFollowed(), Comparator.comparing(seller -> seller.getUserName())));
            }else if(order.equals(Constants.ORDER_NAME_DESCENDANT)){
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

    @Override
    public <T> List<T> orderByLetter(List<T> list, Comparator<? super T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public MessageResponseDTO unfollowUser(Integer userId, Integer userIdToUnFollow) {
        Seller seller = usersRepository.findSellerById(userIdToUnFollow);
        Buyer buyer = usersRepository.findBuyerById(userId);

        if (Utils.isNull(buyer)) {
            throw new BadRequestException("There is not buyer with ID: " + userId);
        }
        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userIdToUnFollow);
        }

        deleteFollowers(seller, buyer);
//        usersRepository.unfollow(seller, buyer);
        return new MessageResponseDTO("Successfully unfollowed user: " + userIdToUnFollow);
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

}
