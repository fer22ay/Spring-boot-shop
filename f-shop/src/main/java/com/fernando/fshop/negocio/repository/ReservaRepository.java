/**
 * 
 */
package com.fernando.fshop.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fernando.fshop.model.Reserva;

/**
 * Interface para definir la operaciones de la base de datos relacionadas con
 * reserva.
 * 
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 02 de marzo del 2020
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

	/***
	 * Definicion de metodo para buscar una reserva en un rango de fecha
	 * 
	 * @param fechaInicio type Date
	 * @param fechaSalida type Date
	 * @return listado de reservas por rango de fechas
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio and r.fechaSalidaRes =:fechasalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechasalida") Date fechasalida);

}
