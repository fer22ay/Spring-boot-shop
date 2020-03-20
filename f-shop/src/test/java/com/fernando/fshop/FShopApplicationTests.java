package com.fernando.fshop;

import static org.junit.Assert.assertTrue;

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
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/**
	 * Prueba para insertar un registro en la tabla user
	 */
	@Test
	public void crearUsuarioTest() {	
		Users users = new Users();
		users.setFirstNameUser("Yener");
		users.setLastNameUser("Macario");
		users.setEmailUser("yener@gmail.com");
		users.setUserName("yener");
		users.setPasswordUser(encoder.encode("123"));
		Users retorno = userRepository.save(users);
		
		assertTrue(retorno.getPasswordUser()
				.equalsIgnoreCase(users.getPasswordUser()));
	}
	/**
	 * Prueba para insertar un registro en la tabla categoria
	 */
	@Test
	public void crearCategoria() {	
		Categoria categoria = new Categoria();
		categoria.setNombreCategoria("CEREALES");
		Categoria resultado = categoriaRepository.save(categoria);
		assertTrue(resultado.getNombreCategoria()
				.equalsIgnoreCase(categoria.getNombreCategoria()));
	}

}
