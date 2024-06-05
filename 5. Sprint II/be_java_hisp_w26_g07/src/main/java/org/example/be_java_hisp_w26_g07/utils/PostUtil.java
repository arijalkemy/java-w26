package org.example.be_java_hisp_w26_g07.utils;

import org.example.be_java_hisp_w26_g07.entity.Post;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class PostUtil {
    private static int counter = 11;

    public static int increaseCounter() {
        return counter++;
    }

    public static final Set<String> listOrder = Set.of("date_asc", "date_desc");

    public static List<Post> getPostOrderByDate(List<Post> postList, String order) {
        if (order == null) return postList;
        return order.equals("date_asc") ?
                postList.stream().sorted(Comparator.comparing(Post::getDate)).toList() :
                postList.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
    }

    public static Boolean orderValidation(String order) {
        if (order == null) {
            return true;
        }
        return listOrder.contains(order.toLowerCase());
    }
}
