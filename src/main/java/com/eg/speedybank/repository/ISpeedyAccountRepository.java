package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.eg.speedybank.entity.SpeedyAccount;

public interface ISpeedyAccountRepository extends CrudRepository<SpeedyAccount, Long> {

}
