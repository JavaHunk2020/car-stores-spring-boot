package com.cubic.it.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubic.it.cars.entity.CarEntity;

public interface CarDaoRepository extends JpaRepository<CarEntity, Integer> {

	
}
