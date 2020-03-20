/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <h1>Categoria</h1> 
 * Clase que representa la tabla <h2>Categoria</h2> en la base de datos
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 18 de marzo del 2020
 *
 */
@Data
@Entity
@Table(name = "categoria", schema = "fernando")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 6238328224883401064L;

	/**
	 * Tags para generar automaticamente el ID en la base de datos PostgreSQL.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategoria;
	private String nombreCategoria;

}
