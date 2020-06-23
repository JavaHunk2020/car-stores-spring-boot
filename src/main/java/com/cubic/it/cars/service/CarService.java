package com.cubic.it.cars.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.cubic.it.cars.controller.vo.CarDTO;
import com.cubic.it.cars.controller.vo.CarPriceDTO;
import com.cubic.it.cars.controller.vo.UserDTO;

public interface CarService {
	
	byte[] fetchImage(int rid);
	List<CarDTO> findAll();
	void updatePhoto(CarDTO carDTO) throws IOException;
	void save(CarDTO carDTO) throws IOException;
	int findCount();
	List<CarDTO> findByPage(int startPage, int pageSize);
	UserDTO validateUser(String username, String password);
	List<CarPriceDTO> carPrices(int cid);
	void deletePriceByCid(int cid);
	void deleteByCid(int cid);
	Optional<CarDTO> findById(int cid);

}
