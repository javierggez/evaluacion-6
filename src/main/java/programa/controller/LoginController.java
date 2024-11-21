package programa.controller;


import programa.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña inválidos");
        }
        if (logout != null) {
            model.addAttribute("message", "Has cerrado sesión correctamente");
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("alumnos", alumnoService.findAll());
        return "home";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }
}