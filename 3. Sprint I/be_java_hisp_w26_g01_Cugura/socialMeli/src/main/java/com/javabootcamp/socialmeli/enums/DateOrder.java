package com.javabootcamp.socialmeli.enums;

import java.util.Comparator;

import com.javabootcamp.socialmeli.model.Post;

public enum DateOrder {
    date_asc(Comparator.comparing(Post::getDate)),
    date_desc(Comparator.comparing(Post::getDate));

    private final Comparator comparator;

    private DateOrder(final Comparator comparator){this.comparator = comparator;}
    public Comparator getDateOrderComparator(){return comparator;}
}
