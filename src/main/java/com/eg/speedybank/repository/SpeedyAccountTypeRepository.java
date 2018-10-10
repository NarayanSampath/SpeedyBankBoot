package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.eg.speedybank.entity.SpeedyAccountType;

public interface SpeedyAccountTypeRepository extends CrudRepository<SpeedyAccountType, Long> {
    public SpeedyAccountType findByTypeName(String speedyAccountType);
}
