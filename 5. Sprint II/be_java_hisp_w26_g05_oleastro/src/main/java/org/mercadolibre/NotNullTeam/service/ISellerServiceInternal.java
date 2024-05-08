package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.model.Seller;

public interface ISellerServiceInternal {
    Seller findById(Long id);
}
