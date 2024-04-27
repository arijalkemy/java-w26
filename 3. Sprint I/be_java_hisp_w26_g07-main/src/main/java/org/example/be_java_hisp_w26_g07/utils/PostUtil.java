package org.example.be_java_hisp_w26_g07.utils;

import org.example.be_java_hisp_w26_g07.entity.Post;

import java.util.Comparator;
import java.util.List;

public class PostUtil {
    private static int counter = 11;

    public static int increaseCounter() {
        return counter++;
    }

    public static List<Post> getPostOrderByDate(List<Post> postList, String order) {
        if (order == null) return postList;
        return switch (order) {
            case "date_asc" -> postList.stream().sorted(Comparator.comparing(Post::getDate)).toList();
            case "date_desc" -> postList.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
            default -> postList;
        };
    }
}
