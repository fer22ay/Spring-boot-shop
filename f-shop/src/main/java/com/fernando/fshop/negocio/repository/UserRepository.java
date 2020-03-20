/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.fshop.model.Users;

/**
 * Interface para definir las operaciones de la base de datos relacionadas con
 * user.
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 02 de marzo del 2020
 *
 */
public interface UserRepository extends JpaRepository<Users, String> {

	/***
	 * Definicion de metodo para buscar los usuarios por nombre
	 * 
	 * @param idUser tipo String
	 * @return
	 */
	public List<Users> findByLastNameUser(String lastNameUser);

	/***
	 * Definicion de metodo para buscar usuario por su identificacion
	 * 
	 * @param identificacionUser
	 * @return
	 */
	public Users findByIdUser(String idUser);

	/**
	 * Definicio de metodo para buscar al usuario por su nombre de usuario
	 * 
	 * @param userName type String
	 * @return name of user
	 */
	public Users findByUserName(String username);

}
