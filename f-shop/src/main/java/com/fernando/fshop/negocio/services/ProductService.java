/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.Product;
import com.fernando.fshop.negocio.repository.ProductRepository;

/**
 * Clase para definir los servicios del producto
 * 
 * @author Fernando Ambrosio
 *
 */
@Service
@Transactional(readOnly = true)
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Metodo para realizar la operacion de guardar un producto.
	 * 
	 * @param product
	 * @return
	 */
	@Transactional
	public Product create(Product product) {
		return this.productRepository.save(product);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un producto.
	 * 
	 * @param product
	 * @return
	 */
	public Product update(Product product) {
		return this.productRepository.save(product);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un producto.
	 * 
	 * @param product
	 */
	@Transactional
	public void delete(Product product) {
		this.productRepository.delete(product);
	}
	
	public Product findByIdPro(Long idPro) {
		return this.productRepository.findByIdPro(idPro).orElse(null);
	}
	
	/**
	 * Metodo para listar todos los productos de la base de datos.
	 * @return
	 */
	public List<Product> findAll(){
		return this.productRepository.findAll();
	}

}










