/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.Users;
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
	 * @param users
	 * @return
	 */
	@Transactional
	public Users create(Users users) {
		return this.userRepository.save(users);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un usuario
	 * 
	 * @param users
	 * @return
	 */
	@Transactional
	public Users update(Users users) {
		return this.userRepository.save(users);
	}

	/**
	 * Metodo para la realizar la operacion de eliminar un usuario
	 * 
	 * @param users
	 */
	@Transactional
	public void delete(Users users) {
		this.userRepository.delete(users);
	}

	/**
	 * Metodo para consultar un cliente por su identificacion
	 * 
	 * @param identificacionUser
	 * @return
	 */
	public Users findByIdentificacion(Long idUser) {
		return this.userRepository.findByIdUser(idUser);
	}

	/**
	 * Metodo para listar todos los usuarios de la base de datos
	 * 
	 * @return
	 */
	public List<Users> findAll() {
		return this.userRepository.findAll();
	}


}







