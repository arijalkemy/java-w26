package org.example.showroom.service;

import org.example.showroom.models.Clothes;

public interface IInternalClotheSaleService {
    Clothes foundByCode(Long code);
}
