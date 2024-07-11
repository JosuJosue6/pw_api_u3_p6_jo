package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
		// Estudiante est = new Estudiante();
		// est.setNombre("Josu");
		// est.setApellido("Ocapana");
		// est.setFechaNacimiento(LocalDateTime.of(2000, 7, 7, 11, 1, 45,5));

		// Creacion de los codigos de estado personalizado*************

		this.estudianteService.guardar(estudiante);
		return ResponseEntity.status(201).body(estudiante);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
		return ResponseEntity.status(238).body(estudiante);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		Estudiante estudiante2 = this.estudianteService.buscar(estudiante.getId());
		if (estudiante.getNombre() != null) {
			estudiante2.setNombre(estudiante.getNombre());
		}
		if (estudiante.getApellido() != null) {
			estudiante2.setApellido(estudiante.getApellido());
		}
		if (estudiante.getFechaNacimiento() != null) {
			estudiante2.setFechaNacimiento(estudiante.getFechaNacimiento());
		}
		this.estudianteService.actualizar(estudiante2);
		return ResponseEntity.status(239).body(estudiante2);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		this.estudianteService.borrar(id);
		
		return ResponseEntity.status(240).body("Borrado ****");
	}

	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscar/2/nuevo/prueba
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		/*String prueba = null;
		prueba.contains("h");*/
		//No envio cabeceras
		//return ResponseEntity.status(240).body(this.estudianteService.buscar(id));
		//para enviar cabeceras primero la construyo
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso.");
		cabeceras.add("Valor ", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id),cabeceras,236 );
	}

	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M&edad=35

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M&edad=24
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=M
	@GetMapping(path = "/genero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		return lista;

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=HolaMundo
	// Nivel
	// 1:http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?prueba=HolaMundo
	@GetMapping(path = "/mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("ID: " + id);
		System.out.println("PRueba: " + prueba);
		return this.estudianteService.buscar(id);
	}

	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/4
	@GetMapping(path = "/test/{id}")
	public Estudiante test(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
		System.out.println(estudiante);
		return this.estudianteService.buscar(id);

	}

}
