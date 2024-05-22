package org.example.compound_key_practice.service;

import org.example.compound_key_practice.models.dtos.ResponsePurchaseDto;

import java.util.List;

public interface IPurchaseService {
    ResponsePurchaseDto createPurchase(ResponsePurchaseDto purchaseDto);
}
