package programa.dto;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AlumnoDTO {
    private Long id;

    @NotNull(message = "El RUT no puede ser nulo")
    @Size(min = 8, max = 12, message = "El RUT debe tener entre 8 y 12 caracteres")
    private String rut;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombre;

    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    private String direccion;

    private Set<MateriaDTO> materiaList = new HashSet<>();

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Set<MateriaDTO> getMateriaList() { return materiaList; }
    public void setMateriaList(Set<MateriaDTO> materiaList) { this.materiaList = materiaList; }
}