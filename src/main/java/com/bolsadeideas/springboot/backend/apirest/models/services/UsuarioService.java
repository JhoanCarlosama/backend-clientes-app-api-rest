package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.DAO.IUsuarioDAO;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUsername(username);

        if(usuario == null) {
            logger.error("Error en el login: no existe el usuario '" + username + "' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "' en el sistema");
        }

        List<GrantedAuthority> authorities =
                usuario.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                        .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                        .collect(Collectors.toList());

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(),
                true,
                true,
                true,
                authorities
                );
    }

    @Override

    public Usuario findByUsername(String username) {
        return  usuarioDAO.findByUsername(username);
    }
}
