package com.fernando.fshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 10 de febrero del 2020
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2245881355669730587L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idRes;
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	//@Temporal -> para capturar solo la fecha
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;


}
