package org.example.compound_key_practice.repository;

import org.example.compound_key_practice.models.Purchase;
import org.example.compound_key_practice.models.PurchaseCompoundKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, PurchaseCompoundKey> {
}
