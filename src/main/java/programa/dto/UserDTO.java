package programa.dto;

import programa.model.Role;
import java.util.List;
import jakarta.validation.constraints.*;

public class UserDTO {
    @NotNull(message = "El username no puede ser nulo")
    @Size(min = 4, max = 50, message = "El username debe tener entre 4 y 50 caracteres")
    private String username;

    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
    private String password;

    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "Debe ser un email válido")
    private String email;

    @NotEmpty(message = "La lista de roles no puede estar vacía")
    private List<Role> roles;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }


    public String getName() { return name; }  // Agregado
    public void setName(String name) { this.name = name; }  // Agregado

    public String getEmail() { return email; }  // Agregado
    public void setEmail(String email) { this.email = email; }  // Agregado
}