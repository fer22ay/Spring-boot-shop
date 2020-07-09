/**
 * 
 */
package com.fernando.fshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernando.fshop.model.Role;
import com.fernando.fshop.model.Users;
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

	/**
	 * Prueba para listar los datos de la tabla Role de la base de datos.
	 */
	/*
	 * @Test public void testListRoles() { List<Role> roles =
	 * roleRepository.findAll(); for (Role role : roles) { System.out.println(role);
	 * } assertThat(roles).size().isGreaterThan(0); }
	 */

	/**
	 * Prueba para insertar un registro en la tabla role
	 */

	/*
	 * @Test public void crearRole() { Role role = new Role();
	 * role.setNameRol("USER"); role.setDescripcionRol("ROLE_USER"); Role retorno =
	 * roleRepository.save(role);
	 * 
	 * assertTrue(retorno.getNameRol().equalsIgnoreCase(role.getNameRol())); }
	 */

}
