package org.example.be_java_hisp_w26_g04.repository.promotion;

import org.example.be_java_hisp_w26_g04.model.Promotion;
import org.example.be_java_hisp_w26_g04.util.crud.ICRUD;

import java.util.Optional;
import java.util.Set;

public interface IPromotionRepository extends ICRUD<Promotion> {
    int save(Promotion promotion);
    Set<Promotion> findAll();

    @Override
    Optional<Promotion> findById(int id);
}
