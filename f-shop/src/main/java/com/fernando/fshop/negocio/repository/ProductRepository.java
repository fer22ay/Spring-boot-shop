/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.fshop.model.Product;

/**
 * Interface para definir las operaciones de la base de datos relacionada con la
 * tabla product.
 * 
 * @author Fernando Ambrosio
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Definicion de metodo para listar producto por Id
	 * 
	 * @param idPro tipo Long
	 * @return Datos del producto
	 */
	public Optional<Product> findByIdPro(Long idPro);

}
