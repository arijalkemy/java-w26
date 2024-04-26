package com.group03.sprint1.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.dto.Mapper;
import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.PublicationListDTO;
import com.group03.sprint1.dto.response.SellerPromotionCountResponseDTO;
import com.group03.sprint1.entity.Publication;
import com.group03.sprint1.entity.Seller;
import com.group03.sprint1.entity.UserData;
import com.group03.sprint1.exception.entity.BadRequestException;
import com.group03.sprint1.exception.entity.NotFoundException;
import com.group03.sprint1.repository.IProductsRepository;
import com.group03.sprint1.repository.IUsersRepository;
import com.group03.sprint1.repository.implementation.ProductsRepositoryImpl;
import com.group03.sprint1.repository.implementation.UsersRepositoryImpl;
import com.group03.sprint1.service.IPublicationsService;
import com.group03.sprint1.utils.Constants;
import com.group03.sprint1.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationsServiceImpl implements IPublicationsService {

    private final IProductsRepository productsRepository;
    private final IUsersRepository usersRepository;

    private ObjectMapper objectMapper;

    public PublicationsServiceImpl(ProductsRepositoryImpl productsRepository,
                                   UsersRepositoryImpl usersRepository){
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private List<PublicationDTO> filterListByOrder(List<PublicationDTO> publicationDTOList, String order){
        if (Utils.isNotNull(order) && order.equals(Constants.ORDER_ASCENDANT)) {
            return publicationDTOList.stream()
                    .sorted(Comparator.comparing(PublicationDTO::getDate))
                    .collect(Collectors.toList());
        }

        return publicationDTOList.stream()
                .sorted(Comparator.comparing(PublicationDTO::getDate).reversed())
                .collect(Collectors.toList());

    }

    @Override
    public SellerPromotionCountResponseDTO countPublicationsInPromotionForSeller(Integer userId) {
        Seller seller = usersRepository.findSellerById(userId);

        if (Utils.isNull(seller)) {
            throw new BadRequestException("There is not seller with ID: " + userId);
        }

        SellerPromotionCountResponseDTO responseDTO = new SellerPromotionCountResponseDTO();
        responseDTO.setUserId(userId);
        responseDTO.setUserName(seller.getUserName());
        responseDTO.setPromoProductsCount(
                seller.getPublications().stream().filter(
                        publication -> publication.isHasPromo()
                        ).count()
        );
        return responseDTO;
    }

    @Override
    public List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order){

        if (Utils.isNotNull(order) && !order.equals(Constants.ORDER_ASCENDANT) && !order.equals(Constants.ORDER_DESCENDANT)) {
            throw new BadRequestException("Invalid order type.");
        }

        List<UserData> userSellersFollowed = usersRepository.findBuyerSellersFollowedByUserId(userId);

        if(Utils.isNull(userSellersFollowed)){
            throw new BadRequestException("The specified user does not exist in the system.");
        } else if (userSellersFollowed.isEmpty()){
            throw new NotFoundException("The specified user does not have any followed sellers.");
        }

        List<PublicationDTO> filteredPublications = new ArrayList<>();

        for (UserData sellerUser : userSellersFollowed) {
            Seller seller = usersRepository.findSellerById(sellerUser.getUserId());
            if (Utils.isNotNull(seller) && seller.getPublications() != null) {
                filteredPublications.addAll(
                        seller.getPublications().stream()
                                .filter(publication -> publication.getDate() != null && publication.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                                .map(publication -> objectMapper.convertValue(publication, PublicationDTO.class))
                                .collect(Collectors.toList())
                );
            }
        }

        if(filteredPublications.isEmpty()){
            throw new NotFoundException("There are no publications in the last 2 weeks for the specified user.");
        }

        return filterListByOrder(filteredPublications, order);
    }

    @Override
    public PublicationListDTO getAllPublications(String productName, Double minTotal, Double maxTotal, String order) {
        List<Seller> sellers = usersRepository.showSellers();
        List<Publication> publications = new ArrayList<>();

        for (Seller seller : sellers) {
            publications.addAll(seller.getPublications());
        }

        publications = Utils.searchProductByName(publications, productName);
        publications = Utils.getPublicationsInRange(publications, minTotal, maxTotal);
        publications = Utils.sortPublicationsByTotalPrice(publications, order);

        return new PublicationListDTO(Mapper.mapPublicationListToDTO(publications));
    }
}
