package com.eg.speedybank.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.speedybank.entity.SpeedyUser;

@Repository
public interface UserRepository extends CrudRepository<SpeedyUser, Long>{
	public SpeedyUser findByEmail(String email);
}
