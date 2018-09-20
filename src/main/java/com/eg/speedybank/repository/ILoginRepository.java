package com.eg.speedybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.eg.speedybank.entity.SpeedyUser;

public interface ILoginRepository extends CrudRepository<SpeedyUser, Long> {
	public SpeedyUser findByEmail(String email);
}
