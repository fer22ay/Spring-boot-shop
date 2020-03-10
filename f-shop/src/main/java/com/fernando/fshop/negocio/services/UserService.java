/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.User;
import com.fernando.fshop.negocio.repository.UserRepository;

/**
 * Clase para definir los servicios del Usuario
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 02 de marzo del 2020
 */
@Service
@Transactional(readOnly = true) // <-- Esto va indicar que las operaciones que no tengan
								// la anotacion @Transaccional lo va tomar en modo lectura.
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Metodo para realizar la operacion de guardar un usuario
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public User create(User user) {
		return this.userRepository.save(user);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un usuario
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public User update(User user) {
		return this.userRepository.save(user);
	}

	/**
	 * Metodo para la realizar la operacion de eliminar un usuario
	 * 
	 * @param user
	 */
	@Transactional
	public void delete(User user) {
		this.userRepository.delete(user);
	}

	/**
	 * Metodo para consultar un cliente por su identificacion
	 * 
	 * @param identificacionUser
	 * @return
	 */
	public User findByIdentificacion(String identificacionUser) {
		return this.userRepository.findByIdentificacion(identificacionUser);
	}

	/**
	 * Metodo para listar todos los usuarios de la base de datos
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
