package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	//http://localhost:8080/API/v1.0/Matricula/materias/guardar 
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Materia materia) {

		this.materiaService.actualizar(materia);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Materia materia) {
		// TODO Auto-generated method stub
		Materia materia2 = this.materiaService.buscar(materia.getId());
		if (materia.getNombre()!= null) {
			materia2.setNombre(materia.getNombre());
		}
		if (materia.getCreditoHora()!= null) {
			materia2.setCreditoHora(materia.getCreditoHora());
		}
		if (materia.getEstado()!= null) {
			materia2.setEstado(materia.getEstado());
		}
		if (materia.getHorasSemestre()!= null) {
			materia2.setHorasSemestre(materia.getHorasSemestre());
		}
		this.materiaService.actualizar(materia2);
	}

	//http://localhost:8080/API/v1.0/Matricula/materias/buscar/
	@GetMapping(path = "/buscar/{id}")
	public Materia buscar(@PathVariable Integer id) {

		return this.materiaService.buscar(id);
	}

	//http://localhost:8080/API/v1.0/Matricula/materias/borrar/
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {

		this.materiaService.borrar(id);
	}

}
