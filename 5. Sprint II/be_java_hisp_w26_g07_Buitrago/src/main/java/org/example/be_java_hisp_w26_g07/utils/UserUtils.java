package org.example.be_java_hisp_w26_g07.utils;

import org.example.be_java_hisp_w26_g07.dto.users.UserInfoFollowsDto;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserUtils {
    public static final Set<String> listOrder = Set.of("name_asc", "name_desc");

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

    public static Boolean orderValidation(String order) {
        if (order == null) {
            return true;
        }
        return listOrder.contains(order.toLowerCase());
    }
}
