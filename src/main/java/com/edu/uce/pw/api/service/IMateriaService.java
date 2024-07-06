package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaService {
	
	public void guardar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public Materia buscar(Integer id);
	
	public void borrar(Integer id);
	
	public List<Materia> buscarMateria (String estado);
	

}
