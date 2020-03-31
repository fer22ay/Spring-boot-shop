/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.fshop.model.Categoria;

/**
 * Interfaz para definir las operaciones de la base de datos relacionada con
 * <h1>Categoria</h1>
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 18 de marzo del 2020
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	/**
	 * Metodo para listar los datos de la tabla
	 * <h2>categoria</h2> por nombre.
	 * 
	 * @param nombreCategoria
	 * @return lista de la tabla
	 */
	public List<Categoria> findByNombreCategoria(String nombreCategoria);

	/**
	 * Metodo para buscar un registro de la tabla
	 * <h2>categoria</h2> por medio de su id.
	 * 
	 * @param idCategoria tipo Long.
	 * @return los datos de la categoria que corresponda el id.
	 */
	public Categoria findByIdCategoria(Long idCategoria);

}






