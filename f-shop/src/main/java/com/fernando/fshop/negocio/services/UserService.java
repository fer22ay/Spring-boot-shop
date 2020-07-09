/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	private final BCryptPasswordEncoder encoder;
	
	public UserService(UserRepository userRepository) {
		this.encoder = new BCryptPasswordEncoder();
		this.userRepository = userRepository;
	}
	
	/**
	 * Metodo para realizar la operacion de guardar un usuario
	 * @param users
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Users create(Users users) throws Exception {
		if (checkUsernameAvailable(users) && checkPasswordValid(users)) {
			/**
			 * <h1>Guardar password Encriptado</h1>
			 * <p>
			 * con el medoto {@code encode} obtenemos el password y lo guardamos en la variable
			 * encodePass para luego pasarla a la Entity y guarde el password encriptado.
			 */
			String encodePass = encoder.encode(users.getPasswordUser());
			users.setPasswordUser(encodePass);
			users = userRepository.save(users);
		}
		return users;
	}

	/**
	 * Metodo para realizar la operacion de actualizar un usuario
	 * 
	 * @param users
	 * @return
	 */
	@Transactional
	public Users update(Users fromUser) {
		Users toUser = findByIdentificacion(fromUser.getIdUser());
		mapUser(fromUser, toUser);
		return this.userRepository.save(toUser);
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
	public Users findByIdentificacion(String idUser) {
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

	/**
	 * Funcion booleana para validar si el usuario esta habilitado para poder
	 * crearlo.
	 * 
	 * @param users {@link Users}
	 * @return true si el usuario no existe.
	 * @throws Exception
	 */
	private boolean checkUsernameAvailable(Users users) throws Exception {
		Optional<Users> userFound = userRepository.findByUserName(users.getUserName());
		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}

	/**
	 * Funcion booleana para comparar si el password ingresado es el mismo con el
	 * password confirmado
	 * 
	 * @param users {@link Users}
	 * @return true si los dos password son iguales.
	 * @throws Exception
	 */
	private boolean checkPasswordValid(Users users) throws Exception {
		if (!users.getPasswordUser().equals(users.getConfirmPasswordUser())) {
			throw new Exception("Password y Confirm password no son iguales");
		}
		return true;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapUser(Users from, Users to) {
		to.setUserName(from.getUserName());
		to.setFirstNameUser(from.getFirstNameUser());
		to.setLastNameUser(from.getLastNameUser());
		to.setEmailUser(from.getEmailUser());
		to.setRoles(from.getRoles());
	}

}
