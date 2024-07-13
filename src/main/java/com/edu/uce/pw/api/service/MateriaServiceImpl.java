package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;	
	
	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizar(materia);
	}

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepository.eliminar(id);
	}

	@Override
	public List<Materia> buscarMateria(String estado) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarMateria(estado);
	}

	@Override
	public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		List<Materia> ls = this.materiaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTO> lsFin = new ArrayList<>();
		
		for(Materia mat: ls) {
			lsFin.add(this.convertir(mat));
		}
		return lsFin;
	}
	
	private MateriaTO convertir (Materia materia) {
		MateriaTO materiaTO = new MateriaTO();
		materiaTO.setId(materia.getId());
		materiaTO.setEstado(materia.getEstado());
		materiaTO.setCreditoHora(materia.getCreditoHora());
		materiaTO.setHorasSemestre(materia.getHorasSemestre());
		materiaTO.setNombre(materia.getNombre());
		return materiaTO;
	}

}
