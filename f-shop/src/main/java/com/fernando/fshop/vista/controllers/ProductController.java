/**
 * 
 */
package com.fernando.fshop.vista.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.fshop.model.Product;
import com.fernando.fshop.negocio.services.ProductService;

/**
 * Clase para controlar las operaciones de la tabla product.
 * 
 * @author Fernando Ambrosio
 *
 */
@Controller
@RequestMapping("app")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		List<Product> listProducts = productService.findAll();
		mav.addObject("title", "List of Product");
		mav.addObject("products", listProducts);
		mav.setViewName("product");
		return mav;
	}

	@GetMapping("/frmProduct")
	public ModelAndView createProduct() {
		ModelAndView mav = new ModelAndView();
		
		return mav;

	}

}










