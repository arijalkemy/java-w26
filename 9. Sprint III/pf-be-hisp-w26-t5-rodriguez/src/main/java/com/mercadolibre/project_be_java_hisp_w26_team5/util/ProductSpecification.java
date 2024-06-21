package com.mercadolibre.project_be_java_hisp_w26_team5.util;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ProductFilterRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {

    public Specification<Product> getAllBySpec (ProductFilterRequestDTO request){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getIdSeller() != null){
                predicates.add(criteriaBuilder.equal(root.get("seller").get("id"), request.getIdSeller()));
            }

             if (request.getName() != null){
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%"));
            }

             if (request.getMinPrice() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), request.getMinPrice()));
            }

             if (request.getMaxPrice() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), request.getMaxPrice()));
            }


             if (request.getType() != null && !request.getType().isEmpty())
            {
                List<Predicate> typePredicates = new ArrayList<>();
                for (String type : request.getType())
                {
                    typePredicates.add(criteriaBuilder.equal(root.get("type"), type));
                }
                predicates.add(criteriaBuilder.or(typePredicates.toArray(new Predicate[0])));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
