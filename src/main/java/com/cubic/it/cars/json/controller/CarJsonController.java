package com.cubic.it.cars.json.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v3")
public class CarJsonController {
	
/*	@Autowired
	private CarDao carDao;
	
	@Autowired
	@Qualifier("pkdataSource")
	private DataSource dataSource;
	
	
	@GetMapping("car/prices")
	public List<CarPriceDTO>  carPrices(@RequestParam int cid){
		//	show all remaining cars after deleting it
				JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
				String fsql="select  cid ,price,doe from cars_price_tbl where cid = "+cid;
				List<CarPriceDTO> carPriceDTOs=jdbcTemplate.query(fsql, new BeanPropertyRowMapper(CarPriceDTO.class));
				return carPriceDTOs;
	}
	
	//http://localhost:9999/car-stores-mvc/v3/cars/1
	@DeleteMapping("/cars/{cid}")
	public List<CarEntity>  deleteCar(@PathVariable int cid) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from cars_tbl where cid = "+cid;
		jdbcTemplate.update(sql);
		
		//show all remaining cars after deleting it
		String fsql="select  cid as id,color,model,price,mfg,description,doe from cars_tbl";
		List<CarEntity> carLista=jdbcTemplate.query(fsql, new BeanPropertyRowMapper(CarEntity.class));
		return carLista;
		
	}
	
   //	/http://localhost:9999/car-stores-mvc/v3/cars/1
	@GetMapping("/cars/{cid}")
	public CarEntity  showCar(@PathVariable int cid) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select  cid as id,color,model,price,mfg,description,doe from cars_tbl where cid = "+cid;
		CarEntity carEntity=(CarEntity)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(CarEntity.class));
		return carEntity;
	}
	
	//@RequestBody - it reads json data from request body and converts into Java Object
	//@ModelAttribute - it reads data from form parameter and converts into Java Object
	@PostMapping("/cars")
	public List<CarEntity> createCar(@RequestBody CarEntity carEntity) throws IOException {
		carDao.save(carEntity);
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select  cid as id,color,model,price,mfg,description,doe from cars_tbl";
		List<CarEntity> carLista=jdbcTemplate.query(sql, new BeanPropertyRowMapper(CarEntity.class));
		return carLista;
	}
	
	
	@GetMapping("/cars")
	public List<CarEntity>  showCar(Model  model) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select  cid as id,color,model,price,mfg,description,doe from cars_tbl";
		List<CarEntity> carLista=jdbcTemplate.query(sql, new BeanPropertyRowMapper(CarEntity.class));
		return carLista;
	}*/
}
