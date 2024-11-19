package com.example.examenparcialtdb.controller;
import com.example.examenparcialtdb.utils.Routes;
import com.example.examenparcialtdb.model.AlumnoModel;
import com.example.examenparcialtdb.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.ALUMNOS_BASE)
public class AlumnoController {
    @Autowired
    private AlumnoService service;

    @GetMapping
    public List<AlumnoModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoModel> buscarPorId(@PathVariable Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }
        AlumnoModel alumno = service.buscarPorId(id);
        if (alumno == null) {
            throw new NullPointerException("Alumno no encontrado");
        }
        return ResponseEntity.ok(alumno);
    }
        //AlumnoModel alumno = service.buscarPorId(id);
        //return alumno != null ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
        //if (id <= 0) {
        //    throw new IllegalArgumentException("El ID debe ser mayor que 0");
        //}
        // Simulamos un error si no se encuentra el alumno
       // throw new NullPointerException("Alumno no encontrado");
    
    

    @PostMapping
    public AlumnoModel guardar(@RequestBody AlumnoModel alumno) {
        return service.guardar(alumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}