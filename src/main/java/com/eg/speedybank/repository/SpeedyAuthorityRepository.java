package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.speedybank.entity.SpeedyAuthority;

@Repository
public interface SpeedyAuthorityRepository extends CrudRepository<SpeedyAuthority, Long> {
    public SpeedyAuthority findByAuthority(String authority);
}
