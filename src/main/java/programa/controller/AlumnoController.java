package programa.controller;

import programa.dto.AlumnoDTO;
import programa.model.Alumno;
import programa.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> findAll() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Alumno> save(@RequestBody AlumnoDTO alumnoDTO) {
        return ResponseEntity.ok(alumnoService.save(alumnoDTO));
    }
}