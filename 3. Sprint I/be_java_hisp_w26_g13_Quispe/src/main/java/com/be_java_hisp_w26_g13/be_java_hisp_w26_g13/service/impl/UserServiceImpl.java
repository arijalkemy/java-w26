package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.InvalidOperation;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IUserService;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    /**
     * This method retrieves the list of sellers that a specific user follows.
     * It first checks if the user exists in the repository, if not, it throws a NotFoundException.
     * Then, it retrieves the list of sellers that the user follows and creates a ResponseFollowedByUserDTO object.
     * This object contains the user's id, username, and a list of UserDTO objects representing the sellers that the user follows.
     * Each UserDTO object contains the seller's id and username.
     *
     * @param userId The id of the user for whom we want to retrieve the list of followed sellers.
     * @return A ResponseFollowedByUserDTO object containing the user's id, username, and a list of followed sellers.
     * @throws NotFoundException If the user with the provided id does not exist in the repository.
     */
    private ResponseFollowedByUserDTO getFollowedSellers(int userId) {

        User user = userRepository.findById(userId);

        if(user == null){
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        List<UserMinimalData> sellers = user.getFollowed();

        ResponseFollowedByUserDTO response = new ResponseFollowedByUserDTO(userId, user.getUserName());

        for (UserMinimalData seller : sellers) {
            UserDTO userDTO = new UserDTO(seller.getUserId(),seller.getUserName());
            response.getFollowed().add(userDTO);
        }

        return response;
    }

    @Autowired
    ObjectMapper mapper;

    private void addFollower(User follower, User userToFollow) {

        UserMinimalData followerMinimal = new UserMinimalData(follower.getUserId(), follower.getUserName());
        UserMinimalData userToFollowMinimal = new UserMinimalData(userToFollow.getUserId(), userToFollow.getUserName());

        List<UserMinimalData> followedList = follower.getFollowed();
        List<UserMinimalData> followerList = userToFollow.getFollowers();

        if (!followedList.contains(userToFollowMinimal) && !followerList.contains(followerMinimal)) {
            if (userToFollow.isVendor()) {
                followedList.add(userToFollowMinimal);
                follower.setFollowed(followedList);
                followerList.add(followerMinimal);
                userToFollow.setFollowers(followerList);
            } else {
                throw new BadRequestException("Cannot follow user that is not a vendor.");
            }
        } else {
            throw new BadRequestException("User with id " + follower.getUserId()
                    + " is already following user with id " + userToFollow.getUserId());
        }
    }


    private void validateFollowUserData(Integer userId, Integer userIdToFollow) {
        if (userId == null || userIdToFollow == null) {
            throw new BadRequestException("The input data is not correctly formatted.");
        } else if (userId < 0 || userIdToFollow < 0) {
            throw new BadRequestException("User IDs cannot be negative.");
        } else if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("User cannot follow itself.");
        }
    }

    /**
     * Performs a follow from the user with id userId to the user with id userIdToFollow.
     * Both IDs must be non-null positive integers (or zero).
     * This method returns a ResponseFollowDTO containing the follower user Id and a
     * message describing the action. It checks if the user was already following the
     * other user or if it tries to follow itself, as well as if the user to follow
     * is a vendor. In those cases, a BadRequestException is thrown.
     * A NotFoundException will be thrown if the users with the received IDs do not
     * exist in the UserRepository.
     *
     * @param  userId  the ID of the user that wants to follow the other one (follower)
     * @param  userIdToFollow the ID of the user to be followed (followed)
     * @return      the follower ID and a message describing the action
     * @see         ResponseFollowDTO
     * @see         BadRequestException
     * @see         NotFoundException
     */
    @Override
    public ResponseFollowDTO followUser(Integer userId, Integer userIdToFollow) {
        validateFollowUserData(userId, userIdToFollow);
        User followerUser = userRepository.findById(userId);
        User followedUser = userRepository.findById(userIdToFollow);
        if (followerUser == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        if (followedUser == null) {
            throw new NotFoundException("User to follow with id " + userIdToFollow + " does not exist.");
        }
        addFollower(followerUser, followedUser);

        return new ResponseFollowDTO(userId, "You are now following user " + followedUser.getUserName());
    }

    /**
     * Retrieves all users from the UserRepository and returns a list containing the
     * corresponding users mapped to a FullUserDTO.
     * @return a list containing all the users in the repository
     * @see IUserRepository
     * @see FullUserDTO
     * @see UserDTO
     */
    @Override
    public List<FullUserDTO> retrieveAllUsers() {
        List<User> users = userRepository.getAll();
        List<FullUserDTO> fullUsersDTO = new ArrayList<>();
        for (User user : users) {
            List<UserDTO> followerList = new ArrayList<>();
            for (UserMinimalData follower : user.getFollowers()) {
                followerList.add(new UserDTO(follower.getUserId(), follower.getUserName()));
            }
            List<UserDTO> followedList = new ArrayList<>();
            for (UserMinimalData followed : user.getFollowed()) {
                followedList.add(new UserDTO(followed.getUserId(), followed.getUserName()));
            }
            List<PostDTO> postList = new ArrayList<>();
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JavaTimeModule())
                    .build();
            for (Post post : user.getPosts()) {
                postList.add(mapper.convertValue(post, PostDTO.class));
            }
            fullUsersDTO.add(new FullUserDTO(user.getUserId(), user.getUserName(), followerList, followedList, postList));
        }

        return fullUsersDTO;
    }



    /**
     * Performs the action of unfollowing a user.
     * @param userId The ID of the user who wants to unfollow another user.
     * @param userIdToUnfollow The ID of the user to unfollow.
     * @return ResponseFollowDTO object indicating the success of the operation.
     */
    @Override
    public ResponseFollowDTO unfollow(int userId, int userIdToUnfollow) {

        UserMinimalData user = unfollowed(userId,userIdToUnfollow);
        deleteFollower(userId,userIdToUnfollow);
        return new ResponseFollowDTO(userIdToUnfollow, "You have unfollowed user " + user.getUserName());
    }

    /**
     * Performs the action of validating if a user exists and if that user has the followed,
     * and removes it from the list of followed
     * @param userId The ID of the user who wants to unfollow another user.
     * @param userIdToUnfollow The ID of the user to unfollow.
     */
    private UserMinimalData unfollowed(int userId, int userIdToUnfollow) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }

        UserMinimalData userFollowed = userRepository.findFollowedById(user, userIdToUnfollow);
        if (userFollowed == null) {
            throw new BadRequestException("User has not followed");
        }

        userRepository.unfollowed(user, userFollowed);
        return userFollowed;
    }

    private void getSortedByUserName(List<UserDTO> userDTOs, String order) {
        if (order.equals("name_asc")) {
            userDTOs.sort(Comparator.comparing(UserDTO::getUserName));
        } else if (order.equals("name_desc")) {
            userDTOs.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        } else {
            throw new BadRequestException("Order should be name_asc or name_desc.");
        }
    }


    /**
     * Returns a sorted list of the vendors that the user with id userId follows.
     * If order equals "name_asc" the list is sorted by userName from A to Z. The
     * opposite happens if order equals "name_desc". If order is empty, the list is
     * returned unordered.
     *
     * @param userId id of the user to get followed list from
     * @param order sorts the list either ascending (name_asc) or descending (name_desc)
     * @return the sorted (or not) list of vendors that the user follows
     * @see ResponseFollowedByUserDTO
     */
    @Override
    public ResponseFollowedByUserDTO getOrderedFollowedSellers(int userId, String order) {
        if (order == null) {
            return getFollowedSellers(userId);
        }

        ResponseFollowedByUserDTO userFollowedDTO = getFollowedSellers(userId);
        List<UserDTO> followed = userFollowedDTO.getFollowed();

        getSortedByUserName(followed, order);
        return userFollowedDTO;
    }


    /**
     * Performs the action of validating if a user exists and if that user has the follower,
     * and removes it from the list of follower
     * @param userId The ID of the user who wants to unfollow another user.
     * @param userIdUnfollower The ID of the user to unfollow.
     */
    private void deleteFollower(int userId, int userIdUnfollower) {
        User userFollower = userRepository.findById(userIdUnfollower);
        UserMinimalData userFollowerMinimal = userRepository.findFollowerById(userFollower, userId);

        if (userFollower == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }

        if (userFollowerMinimal == null) {
            throw new BadRequestException("User has not follower");
        }

        userRepository.deleteFollower(userFollower, userFollowerMinimal);
    }


    /**
     * Use case us-0003's method
     * It searches in userRepository if there are some user with the userId parameter
     * if there aren't any, then throws a not found exception
     * if that user hasn't any post, then throws a bad request exception
     * else add the user id, userName and a list of followed users in followers array from ResponseUserFollowersDTO
     * @author miaramosml
     * @param userId int
     * @return ResponseUserFollowersDTO
     * @exception NotFoundException on user not found
     * @exception BadRequestException on user is not a vendor
     */
    private ResponseUserFollowersDTO getFollowersList(int userId) {
        //compruebo que exista el user, sino tiro una excepcion
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist");
        }
        if (!user.isVendor()){
            throw new BadRequestException("User with id " + userId + " is not a vendor user, non-vendor users cannot have followers");
        }
        //creo la lista de DTOs de followers para ese user
        List<UserDTO> followerDTOList = new ArrayList<>();
        for (UserMinimalData follower : user.getFollowers()) {
            UserDTO followerDTO = new UserDTO(follower.getUserId(), follower.getUserName());
            followerDTOList.add(followerDTO);
        }
        // creo el DTO de la response
        ResponseUserFollowersDTO responseDTO = new ResponseUserFollowersDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setUserName(user.getUserName());
        responseDTO.setFollowers(followerDTOList);

        return responseDTO;

    }

    /**
     * Retrieves the count of followers for a specified user if they are a vendor.
     *
     * @param userId The ID of the user for whom to retrieve the follower count.
     * @return A {@link ResponseFollowersCountDTO} object containing the user's ID, user's name, and the count of followers.
     * @throws NotFoundException if no user is found with the given userId.
     * @throws InvalidOperation if the user identified by userId is not a vendor.
     */
    @Override
    public ResponseFollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist");
        }

        if(!user.isVendor()){
            throw new InvalidOperation("User with id " + userId + " is not a vendor user, non-vendor users cannot have followers");
        }

        ResponseFollowersCountDTO dto = new ResponseFollowersCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowersCount(user.getFollowers().size());

        return dto;
    }

    /**
     * Returns a sorted list of the user's followers. The user must have the id userId.
     * If order equals "name_asc" the list is sorted by userName from A to Z. The
     * opposite happens if order equals "name_desc". If order is empty, the list is
     * returned unordered.
     *
     * @param userId id of the user to get the followers list from
     * @param order sorts the list either ascending (name_asc) or descending (name_desc)
     * @return the sorted (or not) list of users that follow the vendor
     * @see ResponseFollowedByUserDTO
     */
    @Override
    public ResponseUserFollowersDTO getOrderedFollowersList(int userId, String order) {
        if (order == null) {
            return getFollowersList(userId);
        }

        ResponseUserFollowersDTO userFollowersDTO = getFollowersList(userId);
        List<UserDTO> followers = userFollowersDTO.getFollowers();

        getSortedByUserName(followers, order);
        return userFollowersDTO;
    }
}
