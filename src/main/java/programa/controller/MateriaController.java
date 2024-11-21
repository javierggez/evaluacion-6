package programa.controller;

import programa.dto.MateriaDTO;
import programa.model.Materia;
import programa.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "*")
public class MateriaController {

    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping
    public ResponseEntity<Materia> save(@RequestBody MateriaDTO materiaDTO) {
        return ResponseEntity.ok(materiaService.save(materiaDTO));
    }

    @GetMapping
    public ResponseEntity<List<Materia>> findAll() {
        return ResponseEntity.ok(materiaService.findAll());
    }
}