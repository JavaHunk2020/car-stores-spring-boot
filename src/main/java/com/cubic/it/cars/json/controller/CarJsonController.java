package com.cubic.it.cars.json.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.it.cars.controller.vo.CarDTO;
import com.cubic.it.cars.controller.vo.CarPriceDTO;
import com.cubic.it.cars.service.CarService;


@RestController
@RequestMapping("/v3")
public class CarJsonController {
	
	@Autowired
     private CarService carService;
	
	@GetMapping("/car/prices")
	public List<CarPriceDTO>  carPrices(@RequestParam int cid){
		return carService.carPrices(cid);
	}
	
	//http://localhost:9999/car-stores-mvc/v3/cars/1
	@DeleteMapping("/cars/{cid}")
	public List<CarDTO>  deleteCar(@PathVariable int cid) {
		carService.deleteByCid(cid);
		carService.deletePriceByCid(cid);
		//show all remaining cars after deleting it
		return carService.findAll();
	}
	
   //	/http://localhost:9999/car-stores-mvc/v3/cars/1
	@GetMapping("/cars/{cid}")
	public CarDTO  showCar(@PathVariable int cid) {
		Optional<CarDTO> carDTOOpt=carService.findById(cid);
		return carDTOOpt.isPresent()?carDTOOpt.get():null;
	}
	
	//@RequestBody - it reads json data from request body and converts into Java Object
	//@ModelAttribute - it reads data from form parameter and converts into Java Object
	@PostMapping("/cars")
	public List<CarDTO> createCar(@RequestBody CarDTO carDTO) throws IOException {
		carService.save(carDTO);
		return carService.findAll();
	}
	
	
	@GetMapping("/cars")
	public List<CarDTO>  showCar(Model  model) {
		return carService.findAll();
	}
}
