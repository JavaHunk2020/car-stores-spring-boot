package com.cubic.it.cars.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubic.it.cars.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUseridAndPassword(String userid,String password);
	public Optional<UserEntity> findByUserid(String userid);
	public Optional<UserEntity> findByUseridAndPasswordAndName(String userid,String password,String name);
}

