package org.example.be_java_hisp_w26_g07.utils;

import org.example.be_java_hisp_w26_g07.dto.UserInfoFollowsDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserUtils {
    public static List<UserInfoFollowsDto> getUserInfoFollowsDtoByOrder(List<UserInfoFollowsDto> userInfoFollowsDto,
                                                                        String order) {
        if (order == null) return userInfoFollowsDto;
        return switch (order) {
            case "name_asc" ->
                    userInfoFollowsDto.stream().sorted(Comparator.comparing(UserInfoFollowsDto::getName)).toList();
            case "name_desc" ->
                    userInfoFollowsDto.stream().sorted(Comparator.comparing(UserInfoFollowsDto::getName).reversed()).toList();
            default -> userInfoFollowsDto;
        };
    }
}
