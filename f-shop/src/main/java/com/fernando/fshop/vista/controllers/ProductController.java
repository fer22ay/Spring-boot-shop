/**
 * 
 */
package com.fernando.fshop.vista.controllers;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.fshop.model.Product;
import com.fernando.fshop.negocio.services.ProductService;
import com.fernando.fshop.negocio.services.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase para controlar las operaciones de la tabla product.
 * 
 * @author Fernando Ambrosio
 *
 */
@Controller
@RequestMapping("app")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ReportService reportServie;

	@GetMapping(value = "/product")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		log.info("Listando los productos");
		List<Product> listProducts = productService.findAll();
		mav.addObject("title", "List of Product");
		mav.addObject("products", listProducts);
		mav.setViewName("product");
		log.info("Termine de listar los productos");
		return mav;
	}
	
	@GetMapping(value = "/formProducto")
	public String crearProducto() {
		return "/formProducto";
	}
	
}










