/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fernando.fshop.model.Users;

/**
 * Interface para definir las operaciones de la base de datos relacionadas con
 * user.
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 02 de marzo del 2020
 * @Repository etiqueta opcional
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	/**
	 * Definicion de metodo para buscar los usuarios por nombre de usuario
	 * 
	 * @param userName
	 * @return
	 */
	public Optional<Users> findByUserName(String userName);

	/***
	 * Definicion de metodo para buscar usuario por su identificacion
	 * 
	 * @param identificacionUser
	 * @return
	 */
	public Users findByIdUser(Long idUser);

	/**
	 * Definicio de metodo para buscar al usuario por su nombre de usuario y
	 * password
	 * 
	 * @param userName type String
	 * @return name of user
	 */
	@Query("Select r from Users r where r.userName =: username and r.passwordUser =: password")
	public List<Users> findByUserNameAndPassword(@Param("username") String username,
			@Param("password") String password);

}
