package org.example.showroom.repository;

import org.example.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
