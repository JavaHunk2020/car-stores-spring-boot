package com.cubic.it.cars.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cubic.it.cars.controller.vo.CarDTO;
import com.cubic.it.cars.service.CarService;

//Model /
@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/magic")
	public String uploadImage() {
		return "202";
	}
	
  //	/loadImage ? rid =122
	@GetMapping("/loadImage")
	public void loadImage(@RequestParam int rid,HttpServletResponse response) throws IOException {
		byte[] imaga=carService.fetchImage(rid);
		response.setContentType("img/png");
		ServletOutputStream outputStream=response.getOutputStream();
		if(imaga!=null) {
			outputStream.write(imaga);
		}else {
			outputStream.write(new byte[] {});
		}
		outputStream.flush(); //pusing the response
	}
	
	@GetMapping("/cars")
	public String showCar(Model  model) {
		List<CarDTO> carLista=carService.findAll();
		model.addAttribute("carLista",carLista);
		return "cars";
	}
	
	@GetMapping("/pcars")
	public String pshowCar(@RequestParam(required=false) Integer page,Model  model) {
		int maxRecord=3;
		int startPage=1;
		if(page==null || page<=0) {
			page=1;
		}
		else if(page>1) {
			startPage=((page-1)*maxRecord)+1;  // 1, 4 , 7 ,
			                                                                 //0,3,6 -db index
		}
		List<CarDTO> carLista=carService.findByPage(startPage,maxRecord);
		int totalCount=carService.findCount();
		model.addAttribute("maxRecord",maxRecord);
		model.addAttribute("cpage",page);
		
		model.addAttribute("startPage",startPage);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("carLista",carLista);
		return "pcars";
	}
	
	
	@GetMapping("/addCar")
	public String addCarPage() {
		return "add-car";
	}
	
	@PostMapping("/updatePhoto")
	public String updatePhotoOnly(@ModelAttribute CarDTO carDTO) throws IOException {
		carService.updatePhoto(carDTO);
		return "redirect:/pcars";
	}
	
	@PostMapping("/addCar")
	public String createCar(@ModelAttribute CarDTO carDTO,Model  model) throws IOException {
		carService.save(carDTO);
		model.addAttribute("message","car is uploaded successfully@!!!!");
		return "add-car";
	}

}
