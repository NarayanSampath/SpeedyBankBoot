package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.speedybank.entity.SpeedyUser;

@Repository
public interface IRegisterRepository extends CrudRepository<SpeedyUser, Long> {

}
