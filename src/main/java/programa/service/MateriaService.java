package programa.service;

import programa.dto.MateriaDTO;
import programa.model.Materia;
import programa.model.Alumno;
import programa.repository.MateriaRepository;
import programa.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public MateriaService(MateriaRepository materiaRepository, AlumnoRepository alumnoRepository) {
        this.materiaRepository = materiaRepository;
        this.alumnoRepository = alumnoRepository;
    }

    public Materia save(MateriaDTO materiaDTO) {
        if (materiaDTO.getNombre() == null || materiaDTO.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre de la materia es requerido");
        }

        Materia materia = new Materia();
        materia.setNombre(materiaDTO.getNombre());

        if (materiaDTO.getAlumnoId() != null) {
            Alumno alumno = alumnoRepository.findById(materiaDTO.getAlumnoId())
                    .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
            materia.setAlumno(alumno);
        }

        return materiaRepository.save(materia);
    }

    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }
}