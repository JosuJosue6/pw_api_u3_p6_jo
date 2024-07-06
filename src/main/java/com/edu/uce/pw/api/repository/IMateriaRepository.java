package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public Materia seleccionar(Integer id);
	
	public void eliminar(Integer id);
	
	public List<Materia> seleccionarMateria(String estado);
	
	

}
