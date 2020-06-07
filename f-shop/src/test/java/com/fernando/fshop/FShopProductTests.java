/**
 * 
 */
package com.fernando.fshop;

import static org.junit.Assert.assertTrue;

import org.jfree.util.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernando.fshop.model.Product;
import com.fernando.fshop.negocio.repository.ProductRepository;

/**
 * Clase para realizar pruebas en la tabla product de la base de datos.
 * 
 * @author Fernando Ambrosio
 *
 */
@SpringBootTest
public class FShopProductTests {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;

	/*	@Test
	public void createProduct() {

		Log.info("... Inicia la prueba unitaria ...");
		Product product = new Product();
		product.setNamePro("COCAL-COLA");
		product.setDescriptionPro("BEBIDA CARBONATADA");
		product.setQuantityPro(25);
		product.setPricePro(4.50f);
		product.setActivePro(true);
		Product retorno = productRepository.save(product);
		Log.info(retorno);
		log.info("comparamos el nombre del producto coincida.");
		assertTrue(retorno.getNamePro().equalsIgnoreCase(product.getNamePro()));

	}
	*/

}
