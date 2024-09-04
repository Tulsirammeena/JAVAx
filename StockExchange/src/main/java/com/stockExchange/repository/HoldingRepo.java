package com.stockExchange.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockExchange.entity.HoldingEntity;

@Repository
public interface HoldingRepo extends JpaRepository<HoldingEntity, Integer> {

//	Optional<Set<HoldingEntity>> findHoldingsByUser_UserName(String userName);

	Set<HoldingEntity> getHoldingsByUser_UserName(String userName);
	
}
