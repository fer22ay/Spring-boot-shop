/**
 * 
 */
package com.fernando.fshop.vista.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.fshop.model.Users;
import com.fernando.fshop.negocio.repository.RoleRepository;
import com.fernando.fshop.negocio.services.UserService;

/**
 * @author : Fernando Ambrosio
 * @since : 07 de junio del 2020
 *
 */
@Controller
@RequestMapping("app")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		log.info("Listando los datos de los usuarios");
		model.addAttribute("userForm", new Users());
		model.addAttribute("userList", userService.findAll());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("listTab", "active");
		return "user-form/user-view";
	}

	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm") Users users, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			log.info("Ingrese al if del userForm");
			model.addAttribute("userForm", users);
			model.addAttribute("formTab", "active");
		} else {
			log.info("Ingresando al else para confirmar creacion de usuario");
			try {
				userService.create(users);
				model.addAttribute("userForm", new Users());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				log.info("Ocurrio un exception revisar el metodo createUser de UserController");
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", users);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", userService.findAll());
				model.addAttribute("roles", roleRepository.findAll());
			}
		}
		model.addAttribute("userList", userService.findAll());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form/user-view";
	}
	
	
	@GetMapping(value = "/editUser/{idUser}")
	public String getEditUserForm(Model model, @PathVariable(name = "idUser")String id) {
		Users userToEdit = userService.findByIdentificacion(id);
		
		model.addAttribute("userForm", userToEdit);
		model.addAttribute("userList", userService.findAll());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");
		
		return "user-form/user-view";
	}
	
	@PostMapping(value = "/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm") Users users, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("userForm", users);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				userService.update(users);
				model.addAttribute("userForm", new Users());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", users);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", userService.findAll());
				model.addAttribute("roles", roleRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("userList", userService.findAll());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form/user-view";
	}
	
	@GetMapping(value = "/editUser/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
}














