/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.fshop.model.Provider;

/**
 * @author : Fernando Ambrosio
 * @since : 04 de junio del 2020
 *
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

	/**
	 * Metodo para buscar al proveedor por medio de su identificacion
	 * 
	 * @param idProvider tipo Long
	 * @return los datos de un unico proveedor
	 */
	public Provider findByIdProvider(Long idProvider);

}
