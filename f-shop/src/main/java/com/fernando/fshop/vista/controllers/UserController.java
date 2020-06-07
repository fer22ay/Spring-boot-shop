/**
 * 
 */
package com.fernando.fshop.vista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Fernando Ambrosio
 * @since : 07 de junio del 2020
 *
 */
@Controller
@RequestMapping("app")
public class UserController {
	
	@GetMapping("/userForm")
	public String userForm() {
		return "user-form/user-view";
	}
}













