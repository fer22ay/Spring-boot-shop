/**
 * 
 */
package com.fernando.fshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fernando.fshop.model.Categoria;
import com.fernando.fshop.negocio.services.CategoriaService;

/**
 * @author Fernando Ambrosio
 * @since 27 de marzo del 2020
 *
 */
class CategoriaTests {

	@Autowired
	private CategoriaService categoriaService;
	
	/*
	@Test
	public void createCategoria() {
		Categoria categoria = new Categoria();
		categoria.setNombreCategoria("BEBIDAS");
		categoriaService.create(categoria);
		assertThat(categoria.getIdCategoria()).isNotNull();
	}
*/
}
