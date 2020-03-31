/**
 * 
 */
package com.fernando.fshop;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernando.fshop.model.Role;
import com.fernando.fshop.negocio.repository.RoleRepository;

/**
 * Clase para realizar pruebas
 * 
 * @author Fernando Ambrosio
 *
 */
@SpringBootTest
public class FShopRoleTests {

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void contextLoads() {
	}

	/**
	 * Prueba para insertar un registro en la tabla role
	 */

	/*
	 * @Test public void crearRole() { Role role = new Role();
	 * role.setNameRol("ADMIN"); role.setDescripcionRol("ROLE_ADMIN"); Role retorno
	 * = roleRepository.save(role);
	 * 
	 * assertTrue(retorno.getNameRol().equalsIgnoreCase(role.getNameRol())); }
	 */

}
