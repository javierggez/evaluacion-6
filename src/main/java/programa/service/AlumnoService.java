package programa.service;

import programa.model.Alumno;
import programa.repository.AlumnoRepository;
import programa.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno save(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        alumno.setRut(alumnoDTO.getRut());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setDireccion(alumnoDTO.getDireccion());
        return alumnoRepository.save(alumno);
    }
}