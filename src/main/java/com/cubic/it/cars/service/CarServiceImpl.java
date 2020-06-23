package com.cubic.it.cars.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.it.cars.controller.vo.CarDTO;
import com.cubic.it.cars.controller.vo.CarPriceDTO;
import com.cubic.it.cars.controller.vo.UserDTO;
import com.cubic.it.cars.dao.CarDaoRepository;
import com.cubic.it.cars.dao.CarPriceRepository;
import com.cubic.it.cars.dao.UserRepository;
import com.cubic.it.cars.entity.CarEntity;
import com.cubic.it.cars.entity.CarPriceEntity;
import com.cubic.it.cars.entity.UserEntity;

@Service
@Transactional
public class CarServiceImpl  implements CarService{
	
	/*@Autowired
	private CarDao carDao;*/
	
	@Autowired
	private CarDaoRepository carDaoRepository;
	
	
	@Autowired
	private CarPriceRepository carPriceRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	@Override
	public void deletePriceByCid(int cid)  {
		carPriceRepository.deleteByCid(cid);
	}
	
	@Override
	public void deleteByCid(int cid)  {
		carDaoRepository.deleteById(cid);
	}
	
	@Override
	public List<CarPriceDTO>  carPrices(int cid) {
		 List<CarPriceEntity> list=carPriceRepository.findByCid(cid);
		 return list.stream(). //converting list into Stream<CarPriceEntity>
			map(entity->{   // //converting Stream<CarPriceEntity> into Stream<CarPriceDTO>
			 CarPriceDTO carPriceDTO=new CarPriceDTO();
			 BeanUtils.copyProperties(entity, carPriceDTO);
			 return carPriceDTO; 
		 }).collect(Collectors.toList()); //collecting Stream<CarPriceDTO> into List<CarPriceDTO>
	}
	
	@Override
	public UserDTO validateUser(String username,String password) {
		Optional<UserEntity> userEntity=userRepository.findByUseridAndPassword(username, password);
		if(userEntity.isPresent()) {
			UserDTO userDTO=new UserDTO();	
			BeanUtils.copyProperties(userEntity, userDTO);
			return userDTO;
		}else {
			return null;
		}
	}

	@Override
	public byte[] fetchImage(int rid) {
		CarEntity carEntity=carDaoRepository.findById(rid).get();
		return carEntity.getImage();
	}

	@Override
	public List<CarDTO> findAll() {
		List<CarEntity>  list=carDaoRepository.findAll();
		List<CarDTO> carDTOs=new ArrayList<>();
		for(CarEntity entity: list) {
			CarDTO carDTO=new CarDTO();
			BeanUtils.copyProperties(entity, carDTO);
			carDTOs.add(carDTO);
		}
		return carDTOs;
	}
	
	@Override
	public Optional<CarDTO> findById(int cid) {
		Optional<CarEntity> optional=carDaoRepository.findById(cid);
		CarDTO carDTO=null;
		if(optional.isPresent()) {
			carDTO=new CarDTO();
			BeanUtils.copyProperties(optional.get(), carDTO);
		}
		return Optional.ofNullable(carDTO);
	}

	@Override
	public void updatePhoto(CarDTO carDTO) throws IOException {
		CarEntity carEntity=carDaoRepository.findById(carDTO.getId()).get();
		if(carEntity.getPhoto()!=null && carEntity.getPhoto().getBytes().length>0) {
			//entity is loaded inside persistence context
			carEntity.setImage(carEntity.getPhoto().getBytes());
		}
	}

	@Override
	public void save(CarDTO carDTO) throws IOException {
		CarEntity carEntity=new CarEntity();
		BeanUtils.copyProperties(carDTO, carEntity);
		carDaoRepository.save(carEntity);
	}

	@Override
	public int findCount() {
		return (int)carDaoRepository.count();
	}

	@Override
	public List<CarDTO> findByPage(int startPage, int pageSize) {
		/*List<CarEntity>  list=carDaoRepository.findByPage(startPage,pageSize);
		List<CarDTO> carDTOs=new ArrayList<>();
		for(CarEntity entity: list) {
			CarDTO carDTO=new CarDTO();
			BeanUtils.copyProperties(entity, carDTO);
			carDTOs.add(carDTO);
		}
		return carDTOs;*/
		return null;
	}

}
