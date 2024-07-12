package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;

	// http://localhost:8080/API/v1.0/Matricula/materias/guardar
	// Nivel 1: http://localhost:8082/API/v1.0/Matricula/materias
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
		
		this.materiaService.guardar(materia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde a la insercion de un recurso.");
		return new ResponseEntity<>(materia,cabeceras,201);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	// Nivel 1: http://localhost:8082/API/v1.0/Matricula/materias
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		this.materiaService.actualizar(materia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion completa de un recurso.");
		return new ResponseEntity<>(materia,cabeceras,238);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
	// Nivel 1: http://localhost:8082/API/v1.0/Matricula/materias
	@PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {

		materia.setId(id);
		Materia materia2 = this.materiaService.buscar(materia.getId());
		if (materia.getNombre() != null) {
			materia2.setNombre(materia.getNombre());
		}
		if (materia.getCreditoHora() != null) {
			materia2.setCreditoHora(materia.getCreditoHora());
		}
		if (materia.getEstado() != null) {
			materia2.setEstado(materia.getEstado());
		}
		if (materia.getHorasSemestre() != null) {
			materia2.setHorasSemestre(materia.getHorasSemestre());
		}
		this.materiaService.actualizar(materia2);
		
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion parcial de un recurso.");
		return new ResponseEntity<>(materia2,cabeceras,239);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/buscar/
	// Nivel 1: http://localhost:8082/API/v1.0/Matricula/materias
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> buscar(@PathVariable Integer id) {

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la actualizacion parcial de un recurso.");
		return new ResponseEntity<>(this.materiaService.buscar(id),cabeceras,236);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/borrar/
	// Nivel 1: http://localhost:8082/API/v1.0/Matricula/materias/
	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		this.materiaService.borrar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_240", "Corresponde a la eliminacion de un recurso.");
		return new ResponseEntity<>("Borrado",cabeceras,240);
	}

	// NIVEL 1:
	// http://localhost:8082/API/v1.0/Matricula/materias/materia?estado=Matriculado
	@GetMapping(path = "/materia", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Materia>> buscarMateria(@RequestParam String estado) {
		//List<Materia> lista = this.materiaService.buscarMateria(estado);
		//return lista;
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la actualizacion parcial de un recurso.");
		return new ResponseEntity<>(this.materiaService.buscarMateria(estado),cabeceras,236);

	}

}
