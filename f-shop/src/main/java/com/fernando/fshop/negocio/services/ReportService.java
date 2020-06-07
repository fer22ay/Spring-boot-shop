/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fernando.fshop.model.Product;
import com.fernando.fshop.negocio.repository.ProductRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Fernando Ambrosio
 * @since : 26 de mayo del 2020
 *
 */
@Service
public class ReportService {

	@Autowired
	private ProductRepository repository;

	public String exportReport() throws FileNotFoundException, JRException {
		List<Product> products = repository.findAll();
		File file = ResourceUtils.getFile("C:\\Users\\Fernando\\JaspersoftWorkspace\\MyReports\\productRP.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createBY", "Fernando Ambrosio");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		/*
		 * JasperExportManager.exportReportToHtmlFile(jasperPrint,
		 * "C:\\Users\\Fernando\\JaspersoftWorkspace\\MyReports\\productRP.html");
		 */
		final String filePath = "http://localhost:8090/app/descarga\\";
		JasperExportManager.exportReportToPdfFile(jasperPrint, filePath + "productRP.pdf");

		return "Reporte generado con exito";

	}

}
