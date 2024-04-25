package com.group03.sprint1.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;
import com.group03.sprint1.dto.response.PublicationPromoResponseDTO;
import com.group03.sprint1.dto.response.PublicationResponseDTO;
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

    private final IUsersRepository usersRepository;

    private ObjectMapper objectMapper;

    public PublicationsServiceImpl(ProductsRepositoryImpl productsRepository,
                                   UsersRepositoryImpl usersRepository){
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

    /*----------- INDIVIDUAL y BONUS ---------------*/

    @Override
    public void createPublicationPromo(PublicationDTO publicationDTO) {
        if (publicationDTO.isHasPromo()) {
            createPublication(publicationDTO);
        } else {
            throw new BadRequestException("This publication with seller ID: " + publicationDTO.getUserId() + " dont have any promo.");
        }
    }

    @Override
    public PublicationPromoResponseDTO getPublicationPromoCount(Integer userId) {
        Seller seller = findSeller(userId);
        Integer countPromosPublication = Math.toIntExact(seller.getPublications()
                                                        .stream().filter(Publication::isHasPromo).count());

        return new PublicationPromoResponseDTO(seller.getUserId(),
                seller.getUserName(), countPromosPublication);
    }

    @Override
    public PublicationResponseDTO getPublicationsPromo(Integer userId) {
        Seller seller = findSeller(userId);
        List<PublicationDTO> listPublications = seller.getPublications().stream()
                .filter(Publication::isHasPromo)
                .map(p -> (objectMapper.convertValue(p, PublicationDTO.class)))
                .toList();

        if (listPublications.isEmpty()) {
            throw new NotFoundException("There are no promo publications in the user with ID " + seller.getUserId());
        }

        return new PublicationResponseDTO(seller.getUserId(), seller.getUserName(), listPublications);
    }

    private Seller findSeller(Integer userId) {
        Seller seller = usersRepository.findSellerById(userId);
        if (Utils.isNull(seller)) {
            throw new NotFoundException("There is not seller with ID: " + userId);
        }
        return seller;
    }
}
