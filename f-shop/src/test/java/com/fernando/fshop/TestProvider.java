/**
 * 
 */
package com.fernando.fshop;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernando.fshop.model.Provider;
import com.fernando.fshop.negocio.repository.ProviderRepository;

/**
 * @author : Fernando Ambrosio
 * @since : 05 de junio 2020
 *
 */
@SpringBootTest
public class TestProvider {

	@Autowired
	private ProviderRepository providerRepository;
	
	/*
	 * @Test void contextLoads() { }
	 */
	
	/*
	 * @Test public void createProvider() { Provider provider = new Provider();
	 * provider.setAddress("33 Calle 25-30 Zona 12");
	 * provider.setNameProvider("Molinos Modernos de Guatemala");
	 * provider.setPhoneNumber(22771616);
	 * 
	 * Provider retorno = providerRepository.save(provider);
	 * 
	 * assertTrue(retorno.getNameProvider().equalsIgnoreCase(provider.
	 * getNameProvider())); }
	 */
	
}
