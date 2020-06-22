package com.cubic.it.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubic.it.cars.entity.CarPriceEntity;

public interface CarPriceRepository extends JpaRepository<CarPriceEntity, Integer> {

}

