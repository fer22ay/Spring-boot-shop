/**
 * 
 */
package com.fernando.fshop;

import static org.junit.Assert.assertTrue;

import org.jfree.util.Log;
import org.junit.jupiter.api.Test;
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

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void createProduct() {
		/*
		 * Log.info("... testIdentityStrategy ..."); Product product = new Product();
		 * product.setNamePro("PEPSI-COLA");
		 * product.setDescriptionPro("BEBIDA CARBONATADA"); product.setQuantityPro(25);
		 * product.setPricePro(4.50f); product.setActivePro(true); Product retorno =
		 * productRepository.save(product); Log.info(retorno);
		 * assertTrue(retorno.getNamePro().equalsIgnoreCase(product.getNamePro()));
		 */

	}

}
