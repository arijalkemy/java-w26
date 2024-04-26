package org.example.be_java_hisp_w26_g04.repository.promotion;

import org.example.be_java_hisp_w26_g04.model.Promotion;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PromotionRepository implements IPromotionRepository{
    final private Set<Promotion> promotions;

    @Override
    public int update(Promotion Object) {
        return 0;
    }

    @Override
    public void delete(Promotion Object) {

    }

    @Override
    public Optional<Promotion> findById(int promotionId) {
        return promotions.stream().filter(p -> p.getUserId() == promotionId).findFirst();
    }

    public PromotionRepository(){
        promotions = new HashSet<>();
    }

    @Override
    public Set<Promotion> findAll() {
        return promotions;
    }

    @Override
    public int save(Promotion promotion) {
        promotions.add(promotion);
        return promotion.getPromotionId();
    }
}
