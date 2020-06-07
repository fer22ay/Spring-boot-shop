/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla role en la base de datos
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 09 de marzo del 2020
 *
 */
@Data
@Entity
@Table(name = "role", schema = "fernando")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 363422571923148657L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idRol;
	
	private String nameRol;
	
	private String descripcionRol;

	
}
