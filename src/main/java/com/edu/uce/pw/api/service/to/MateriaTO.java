package com.edu.uce.pw.api.service.to;

import java.io.Serializable;
import java.math.BigDecimal;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MateriaTO implements Serializable{
	
	private static final long serialVersionUID = 1683355650124783603L;

	private Integer id;

	private String nombre;

	private Integer horasSemestre;

	private BigDecimal creditoHora;

	private String estado;



	// GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHorasSemestre() {
		return horasSemestre;
	}

	public void setHorasSemestre(Integer horasSemestre) {
		this.horasSemestre = horasSemestre;
	}

	public BigDecimal getCreditoHora() {
		return creditoHora;
	}

	public void setCreditoHora(BigDecimal creditoHora) {
		this.creditoHora = creditoHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
