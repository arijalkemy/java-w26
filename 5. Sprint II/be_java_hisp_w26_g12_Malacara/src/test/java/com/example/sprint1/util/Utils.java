package com.example.sprint1.util;

import com.example.sprint1.dto.*;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Utils {


    public static Stream<List<User>> userProvider() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        file= ResourceUtils.getFile("classpath:users.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});

        return Stream.of(users);
    }

    public static Stream<List<Post>> postProvider() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> posts;

        file= ResourceUtils.getFile("classpath:posts.json");
        posts = objectMapper.readValue(file,new TypeReference<List<Post>>(){});

        return Stream.of(posts);
    }

    public static Stream<List<PostDto>> postDtoProvider() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<PostDto> posts;

        file= ResourceUtils.getFile("classpath:posts.json");
        posts = objectMapper.readValue(file,new TypeReference<List<PostDto>>(){});

        return Stream.of(posts);
    }


    public static Stream<List<UserDto>> userDtoProvider() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDto> users;

        file= ResourceUtils.getFile("classpath:users.json");
        users = objectMapper.readValue(file,new TypeReference<List<UserDto>>(){});

        return Stream.of(users);
    }

    public static List<TestFollowDto> ascendingFollowUserProvider() throws IOException {

        //Instancing arrange variables
        TestFollowDto testFollowDto = new TestFollowDto();
        List<FollowerUsersDto> follerUserDto = new ArrayList<>();
        FollowListDto followListDto = new FollowListDto();
        List<TestFollowDto> testFollowDtos = new ArrayList<>();
        User user = new User();

        //Mapping and extracting Users data
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        //Extracting input users
        file= ResourceUtils.getFile("classpath:testResources/testUnorderedUsers.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});
        testFollowDto.setInputFollow(users);

        //Extracting output users
        file = ResourceUtils.getFile("classpath:testResources/testFollowAscending.json");
        follerUserDto = objectMapper.readValue(file, new TypeReference<List<FollowerUsersDto>>() {});
        followListDto.setUser_id(3);
        followListDto.setUser_name("user3");
        followListDto.setFollowed(follerUserDto);
        testFollowDto.setExpectedOrderedFollow(followListDto);

        //Extracting user data
        file = ResourceUtils.getFile("classpath:testResources/testUser.json");
        user = objectMapper.readValue(file, new TypeReference<User>() {});
        testFollowDto.setUser(user);

        //List Assembly
        testFollowDtos.add(testFollowDto);


        return testFollowDtos;
    }

    public static List<TestFollowDto> descendingFollowerUserProvider() throws IOException {

        //Instancing arrange variables
        TestFollowDto testFollowDto = new TestFollowDto();
        List<FollowerUsersDto> follerUserDto = new ArrayList<>();
        FollowListDto followListDto = new FollowListDto();
        List<TestFollowDto> testFollowDtos = new ArrayList<>();
        User user = new User();

        //Mapping and extracting Users data
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        //Extracting input users
        file= ResourceUtils.getFile("classpath:testResources/testUnorderedUsers.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});
        testFollowDto.setInputFollow(users);

        //Extracting output users
        file = ResourceUtils.getFile("classpath:testResources/testFollowDescending.json");
        follerUserDto = objectMapper.readValue(file, new TypeReference<List<FollowerUsersDto>>() {});
        followListDto.setUser_id(3);
        followListDto.setUser_name("user3");
        followListDto.setFollowed(follerUserDto);
        testFollowDto.setExpectedOrderedFollow(followListDto);

        //Extracting user data
        file = ResourceUtils.getFile("classpath:testResources/testUser.json");
        user = objectMapper.readValue(file, new TypeReference<User>() {});
        testFollowDto.setUser(user);

        //List Assembly
        testFollowDtos.add(testFollowDto);


        return testFollowDtos;
    }

    public static List<TestFollowDto> descendingFollowedUserProvider() throws IOException {

        //Instancing arrange variables
        TestFollowDto testFollowDto = new TestFollowDto();
        List<FollowerUsersDto> follerUserDto = new ArrayList<>();
        FollowListDto followListDto = new FollowListDto();
        List<TestFollowDto> testFollowDtos = new ArrayList<>();
        User user = new User();

        //Mapping and extracting Users data
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        //Extracting input users
        file= ResourceUtils.getFile("classpath:testResources/testUnorderedUsers.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});
        testFollowDto.setInputFollow(users);

        //Extracting output users
        file = ResourceUtils.getFile("classpath:testResources/testFollowDescending.json");
        follerUserDto = objectMapper.readValue(file, new TypeReference<List<FollowerUsersDto>>() {});
        followListDto.setUser_id(3);
        followListDto.setUser_name("user3");
        followListDto.setFollowed(follerUserDto);
        testFollowDto.setExpectedOrderedFollow(followListDto);

        //Extracting user data
        file = ResourceUtils.getFile("classpath:testResources/testUser.json");
        user = objectMapper.readValue(file, new TypeReference<User>() {});
        testFollowDto.setUser(user);

        //List Assembly
        testFollowDtos.add(testFollowDto);


        return testFollowDtos;
    }

    public static List<TestFollowDto> ascendingFollowedUserProvider() throws IOException {

        //Instancing arrange variables
        TestFollowDto testFollowDto = new TestFollowDto();
        List<FollowerUsersDto> follerUserDto = new ArrayList<>();
        FollowListDto followListDto = new FollowListDto();
        List<TestFollowDto> testFollowDtos = new ArrayList<>();
        User user = new User();

        //Mapping and extracting Users data
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        //Extracting input users
        file= ResourceUtils.getFile("classpath:testResources/testUnorderedUsers.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});
        testFollowDto.setInputFollow(users);

        //Extracting output users
        file = ResourceUtils.getFile("classpath:testResources/testFollowAscending.json");
        follerUserDto = objectMapper.readValue(file, new TypeReference<List<FollowerUsersDto>>() {});
        followListDto.setUser_id(3);
        followListDto.setUser_name("user3");
        followListDto.setFollowed(follerUserDto);
        testFollowDto.setExpectedOrderedFollow(followListDto);

        //Extracting user data
        file = ResourceUtils.getFile("classpath:testResources/testUser.json");
        user = objectMapper.readValue(file, new TypeReference<User>() {});
        testFollowDto.setUser(user);

        //List Assembly
        testFollowDtos.add(testFollowDto);


        return testFollowDtos;
    }
}
