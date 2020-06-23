package com.cubic.it.cars.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.cubic.it.cars.entity.CarPriceEntity;

public interface CarPriceRepository extends JpaRepository<CarPriceEntity, Integer> {
	
	public List<CarPriceEntity>  findByCid(int cid);
	
	@Modifying
	public void  deleteByCid(int cid);
}

