package com.sprint.socialmeli.utils;

import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PromoPostDTO;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.exception.BadRequestException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {

    public static Post parsePostDTO(PostDTO postDTO) {
        try {
            Product product = new Product(
                    postDTO.getProduct().getProduct_id(),
                    postDTO.getProduct().getProduct_name(),
                    postDTO.getProduct().getType(),
                    postDTO.getProduct().getColor(),
                    postDTO.getProduct().getBrand(),
                    postDTO.getProduct().getNotes()
            );
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(postDTO.getDate(), formatter);
            return new Post(product, date, postDTO.getCategory(), postDTO.getPrice());
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }

    public static Post parsePostWithPromoDTO(PromoPostDTO postPromoDTO) {
        try {
            Product product = new Product(
                    postPromoDTO.getProduct().getProduct_id(),
                    postPromoDTO.getProduct().getProduct_name(),
                    postPromoDTO.getProduct().getType(),
                    postPromoDTO.getProduct().getColor(),
                    postPromoDTO.getProduct().getBrand(),
                    postPromoDTO.getProduct().getNotes()
            );
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(postPromoDTO.getDate(), formatter);
            return new Post(product, date, postPromoDTO.getCategory(), postPromoDTO.getPrice(), postPromoDTO.getDiscount());
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }
}
