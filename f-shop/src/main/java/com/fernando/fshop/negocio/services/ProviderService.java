/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.Provider;
import com.fernando.fshop.negocio.repository.ProviderRepository;

/**
 * @author : Fernando Ambrosio
 * @since : 04 de junio del 2020
 *
 */
@Service
@Transactional(readOnly = true)
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepository;

	/**
	 * Servicio para realizar la opcion de guardar un proveedor en la base de datos
	 * 
	 * @param provider de tipo {@link Provider}
	 * @return
	 */
	@Transactional
	public Provider create(Provider provider) {
		return this.providerRepository.save(provider);
	}

	/**
	 * Servicio para realizar la opcion de actualizar un proveedor de la base de
	 * datos.
	 * 
	 * @param provider de tipo {@link Provider}
	 * @return
	 */
	@Transactional
	public Provider update(Provider provider) {
		return this.providerRepository.save(provider);
	}

	/**
	 * Servicio para realizar la opcion de eliminacion de un proveedr de la base de
	 * datos
	 * 
	 * @param provider
	 */
	@Transactional
	public void delete(Provider provider) {
		this.providerRepository.delete(provider);
	}

	/**
	 * Servicio para buscar a un proveedor por su identificacion
	 * 
	 * @param idProvider tipo Long
	 * @return los datos de un proveedor por su id.
	 */
	public Provider findByIdProvider(Long idProvider) {
		return this.providerRepository.findByIdProvider(idProvider);
	}

	/**
	 * Servicio que muestra el listado de proveedores.
	 * 
	 * @return los datos de los proveedores registrados en la base de datos
	 */
	public List<Provider> findAll() {
		return this.providerRepository.findAll();
	}

}
