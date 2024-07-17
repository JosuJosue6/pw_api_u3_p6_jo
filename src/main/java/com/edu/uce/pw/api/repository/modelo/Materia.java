package com.edu.uce.pw.api.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.xml.ws.soap.MTOM;

@Entity
@Table(name = "materia")
public class Materia {
	
	@Id
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@Column(name = "mate_id")
	private Integer id;
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_horas_semestre")
	private Integer horasSemestre;
	
	@Column(name = "mate_credito_hora")
	private BigDecimal creditoHora;
	
	@Column(name = "mate_estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;
	
	//GET Y SET
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
