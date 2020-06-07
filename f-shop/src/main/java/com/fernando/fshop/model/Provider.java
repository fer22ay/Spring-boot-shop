/**
 * 
 */
package com.fernando.fshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author : Fernando Ambrosio
 * @since : 04 de junio del 2020
 *
 */
@Data
@Entity
@Table(name = "provider", schema = "fernando")
public class Provider implements Serializable {

	private static final long serialVersionUID = 4984097561226834028L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProvider;

	private String nameProvider;

	private String address;

	private int phoneNumber;
	
	@OneToMany(mappedBy = "provider")
	private List<Product> products;

	public Provider() {

	}

}
