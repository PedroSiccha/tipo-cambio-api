package com.pedrosiccha.tipocambioapi.application;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/login-success")
    public String loginSuccess() {
        // Crea una instancia de Authentication (puedes ajustar esto según tus necesidades)
        Authentication authentication = createAuthentication();

        // Configura el SecurityContextHolder con la autenticación
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Login exitoso";
    }

    private Authentication createAuthentication() {
        // Implementa la creación de Authentication según tus requisitos
        // En este ejemplo, puedes crear un usuario ficticio.
        // Aquí un ejemplo con UsernamePasswordAuthenticationToken:
        return new UsernamePasswordAuthenticationToken(
                "username",
                "password",
                List.of(() -> "ROLE_USER")
        );
    }

}
