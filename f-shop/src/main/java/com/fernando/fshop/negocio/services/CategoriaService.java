/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.Categoria;
import com.fernando.fshop.negocio.repository.CategoriaRepository;

/**
 * <h1>CategoriaService</h1> Clase para definir los servicios de las categorias
 * 
 * @author Fernando Ambrosio
 * @since 18 de marzo del 2020
 *
 */
@Service
@Transactional(readOnly = true)
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	/**
	 * Metodo para realizar la operacion de guardar una categoria
	 * @param categoria
	 * @return
	 */
	@Transactional
	public Categoria create(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	/**
	 * Metodo para realizar la operacion de actualizar una categoria
	 * @param categoria
	 * @return
	 */
	@Transactional
	public Categoria update(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	/**
	 * Metodo para realizar la operacion de eliminar una categoria
	 * @param categoria
	 */
	@Transactional
	public void delete(Categoria categoria) {
		this.categoriaRepository.delete(categoria);
	}
	
	/**
	 * Metodo para realizar la operacion de buscar categoria por su id
	 * @param idCategoria
	 * @return
	 */
	public Categoria findByIdCategoria(Long idCategoria) {
		return this.categoriaRepository.findByIdCategoria(idCategoria);
	}
	
	/**
	 * Metodo para realizar la operacion de listar todas las categorias
	 * @return 
	 */
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}
	
}






