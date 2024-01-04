package com.pedrosiccha.tipocambioapi.domain.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tu lógica para cargar el usuario desde la base de datos u otra fuente

        // Ejemplo básico con un usuario en memoria
        // Deberías adaptar esto a tu lógica de carga de usuarios

        // Simulando cargar roles desde tu base de datos
        List<String> roles = loadUserRolesFromDatabase(username);

        // Crear una lista de GrantedAuthority a partir de los roles
        List<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Devolver un objeto UserDetails con el username, password y authorities
        return new User(username, "password", authorities);
    }

    private List<String> loadUserRolesFromDatabase(String username) {
        // Aquí deberías implementar la lógica para cargar los roles de usuario desde tu base de datos
        // Este es solo un ejemplo, adapta según tu estructura de datos y lógica de negocio
        // Puedes utilizar un repositorio o servicio para interactuar con tu base de datos
        // y obtener los roles asociados al usuario con el nombre de usuario dado.

        // En este ejemplo, asumimos que el usuario tiene el rol "ROLE_USER" por defecto
        List<String> roles = someUserRoleRepository.findByUsername(username)
                .map(userRole -> List.of(userRole.getRole()))
                .orElse(List.of("ROLE_USER"));

        // Agregar lógica adicional según tus necesidades

        return roles;
    }

}
