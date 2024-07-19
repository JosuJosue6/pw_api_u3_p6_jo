package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;



@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}
	
	public EstudianteTO convertir (Estudiante estudiante) {
		EstudianteTO estudianteTO = new EstudianteTO();
		estudianteTO.setId(estudiante.getId());
		estudianteTO.setNombre(estudiante.getNombre());
		estudianteTO.setApellido(estudiante.getApellido());
		estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		estudianteTO.setGenero(estudiante.getGenero());
		return estudianteTO;
	}

	@Override
	public EstudianteTO buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteRepository.seleccionar(id);
		return this.convertir(estudiante);
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		// TODO Auto-generated method stub
		
		List<Estudiante> ls = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> lsTO = new ArrayList<>();
		
		for (Estudiante estudiante : ls) {
			lsTO.add(this.convertir(estudiante));
		}
		
		return lsTO;
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.convertir(this.estudianteRepository.seleccionarPorCedula(cedula));
	}

}
