/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@NamedQuery(name = "Users.findByIdentificacion", query = "Select u from Users u where u.idUser =?1")
public class Users implements Serializable {

	private static final long serialVersionUID = -7735528990277734265L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser; 
	private String firstNameUser;
	private String lastNameUser;
	@Column(unique = true)
	private String emailUser;
	@Column(unique = true)
	private String userName;
	private String passwordUser;
	
	/*
	 * La etiqueta @Transient se utiliza para que jpa sepa que no debe tomarlo
	 * como una columna en la base de datos. 
	*/
	@Transient
	private String confirmPasswordUser;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name = "user_roles"
			,joinColumns = @JoinColumn(name="id_user")
			,inverseJoinColumns = @JoinColumn(name="id_rol"))
	private Set<Role> roles;
	
	public Users() {
		
	}

}








