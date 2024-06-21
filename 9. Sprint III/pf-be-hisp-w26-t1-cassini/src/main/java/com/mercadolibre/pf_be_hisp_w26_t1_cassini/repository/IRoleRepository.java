package com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
