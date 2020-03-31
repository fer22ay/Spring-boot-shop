/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Clase que representa la tabla producto en la base de datos
 * 
 * @author Fernando Ambrosio
 *
 */
@Data
@Entity
@Table(name = "product", schema = "fernando")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 49383584883892985L;
	
	@Id
	@GeneratedValue(generator = "product_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq")
	private Long idPro;
	
	private String namePro;
	
	private String descriptionPro;
	
	private Integer quantityPro;
	
	private Float pricePro; 
	
	private Boolean activePro;
	
	/**
	 * Constructor vacio.
	 */
	public Product() {
		
	}
	
	
}










