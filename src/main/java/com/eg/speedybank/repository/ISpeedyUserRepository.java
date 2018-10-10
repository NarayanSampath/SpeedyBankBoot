package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.eg.speedybank.entity.SpeedyUser;

public interface ISpeedyUserRepository extends CrudRepository<SpeedyUser, Long> {

}
