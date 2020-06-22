package com.cubic.it.cars.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cubic.it.cars.controller.vo.UserDTO;
import com.cubic.it.cars.entity.UserEntity;
import com.cubic.it.cars.service.CarService;


/**
 * 
 * @author Lutfullah
 *
 */
@Controller
public class AuthController {
	
	@Autowired
	private CarService carService;
	
	public AuthController() {
		System.out.println("(@*@&@&Hahahahahahahahha");
	}
	
	
	@GetMapping({"/dasha"})
	public String dashaBoard() {
		return "dasha";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//killing the session
		session.invalidate();
		return "login";
	}
	
	@GetMapping({"/auth","/"})
	public String authPage() {
		return "login";
	}
	
	@PostMapping("/auth")
	public String authPagePost(String username,String password,HttpSession session,Model model) {
		UserEntity entity=null;
		String next="review";
		UserDTO userDTO=carService.validateUser(username, password);
			if(userDTO!=null)  {
			  	model.addAttribute("pdata", userDTO);
				   session.setAttribute("userData", userDTO);
			}	 else {
				 model.addAttribute("message", "Sorry usename and password are not correct!");
				next="login";
			}
		return next;
	}

}
