package com.example.sprint1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String user_name;
    private Set<Integer> followers;
    private Set<Integer> followed;
    private Set<Integer> posts;

    public void addFollowed(Integer id){
        followed.add(id);
    }

    public Integer getCountFollowers(){
        return followers.size();
    }

    public Integer getCountFollowed(){
        return followed.size();
    }

    // Add Isay params for US 0007
    public void addFollower(Integer id){
        followers.add(id);
    }

    public void deleteFollower(Integer id){
        followers.remove(id);
    }

    public void deleteFollowed(Integer id){
        followed.remove(id);
    }
}
