/**
 * 
 */
package com.fernando.fshop.model;

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
@NamedQuery(name = "User.findByIdentificacion", query = "Select u from User u where u.identificacionUser =?1")
public class User implements Serializable {

	private static final long serialVersionUID = -7735528990277734265L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idUser;
	private String firstNameUser;
	private String lastNameUser;
	@Column(unique = true)
	private String emailUser;
	@Column(unique = true)
	private String userName;
	private String passwordUser;
	
	@Transient
	private String confirmPasswordUser;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
			joinColumns = @JoinColumn(name="user_id")
			,inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public User() {
		
	}

}
