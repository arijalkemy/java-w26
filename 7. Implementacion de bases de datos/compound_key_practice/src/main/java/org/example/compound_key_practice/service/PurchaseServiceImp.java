package org.example.compound_key_practice.service;

import org.example.compound_key_practice.models.Purchase;
import org.example.compound_key_practice.models.PurchaseCompoundKey;
import org.example.compound_key_practice.models.dtos.ResponsePurchaseDto;
import org.example.compound_key_practice.repository.IPurchaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImp implements IPurchaseService {
    private final IPurchaseRepository repository;

    public PurchaseServiceImp(IPurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponsePurchaseDto createPurchase(ResponsePurchaseDto purchaseDto) {
        PurchaseCompoundKey key = new PurchaseCompoundKey(
                purchaseDto.getClientId(),
                purchaseDto.getDate()
        );
        Purchase newPurchase = new Purchase();
        newPurchase.setId(key);
        newPurchase.setTotal(purchaseDto.getTotal());
        newPurchase.setQuantity(purchaseDto.getQuantity());
        repository.save(newPurchase);
        return purchaseDto;
    }
}
