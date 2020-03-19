/**
 * 
 */
package com.fernando.fshop.vista.vo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa virtual object para acceder a los datos de la entidad
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 18 de marzo del 2020
 *
 */

@Data
public class UserVO implements Serializable {

	private static final long serialVersionUID = -7735528990277734265L;

	private String firstNameUser;
	private String lastNameUser;
	private String emailUser;
	private String userName;
	private String passwordUser;


}
