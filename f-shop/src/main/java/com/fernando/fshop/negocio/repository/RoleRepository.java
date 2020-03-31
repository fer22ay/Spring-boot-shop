/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.fshop.model.Role;

/**
 * Interface para definir las operaciones de la base de datos relacionada con la
 * tabla role.
 * 
 * @author Fernando Ambrosio
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * Definicion de metodo para consultar un role por su nombre
	 * 
	 * @param nameRol
	 * @return
	 */
	public Role findByNameRol(String nameRol);

	/**
	 * Definicio de metodo para consultar el role por su identificacion
	 * 
	 * @param idRol
	 * @return
	 */
	public Role findByIdRol(Long idRol);

}
