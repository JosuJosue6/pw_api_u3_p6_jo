package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Column(name = "estu_id")
	@Id
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	@Column(name = "estu_genero")
	private String genero;
	
	@Column(name = "estu_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", genero=" + genero + "]";
	}

	/*
	 * TTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTTT
	 * TTTTTTTTTTTTTTTTTTTTT
	 * 
	 * 
	 * */

}
