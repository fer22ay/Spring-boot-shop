/**
 * 
 */
package com.fernando.fshop.vista.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Clase para controlar el login personalizado
 * 
 * @author Fernando Ambrosio
 * @since 21 de marzo del 2020
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = {"/", "/login"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		log.info("Enter main page.");
		String errorMessage = "Invalid username and password.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		log.info("Displaying home page.");
		mav.setViewName("home");
		return mav;
	}
	
}
