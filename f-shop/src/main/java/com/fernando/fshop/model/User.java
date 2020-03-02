/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla user dentro de la base de datos
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 01 de marzo del 2020
 *
 */

@Data
@Entity
@Table(name = "user", schema = "fernando")
public class User implements Serializable {

	private static final long serialVersionUID = -7735528990277734265L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idUser;
	private String nombreUser;
	private String passUser;
	
	public User() {
		
	}

}
