package com.fernando.fshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernando.fshop.model.Categoria;
import com.fernando.fshop.model.Users;
import com.fernando.fshop.negocio.repository.CategoriaRepository;
import com.fernando.fshop.negocio.repository.UserRepository;

@SpringBootTest
class FShopApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * Prueba para consultar todos los registros de la tabla user. Y comprobar si la
	 * tabla no esta vacia.
	 */
	/*
	 * @Test public void consultarUsuarioTests() {
	 * 
	 * List<Users> users = userRepository.findAll(); assertThat(users).isNotEmpty();
	 * }
	 */

	/**
	 * Prueba para insertar un registro en la tabla user. assertTrue verifica que el
	 * password almacenado sea el mismo con el retorno.
	 */
	/*
	 * @Test public void crearUsuarioTest() { Users users = new Users();
	 * users.setFirstNameUser("admin"); users.setLastNameUser("admin");
	 * users.setEmailUser("admin@gmail.com"); users.setUserName("admin");
	 * users.setPasswordUser(encoder.encode("1234")); Users retorno =
	 * userRepository.save(users);
	 * 
	 * assertTrue(retorno.getPasswordUser().equalsIgnoreCase(users.getPasswordUser()
	 * )); }
	 */

}
