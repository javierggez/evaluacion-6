package programa.controller;


import programa.dto.UserDTO;
import programa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.signup(userDTO));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserDTO userDTO) {
        String token = userService.signin(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }
}