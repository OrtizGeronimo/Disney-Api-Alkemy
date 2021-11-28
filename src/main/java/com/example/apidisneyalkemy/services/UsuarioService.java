package com.example.apidisneyalkemy.services;

import com.example.apidisneyalkemy.entities.Usuario;
import com.example.apidisneyalkemy.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Transactional
    public Usuario findByUsuarioAndContrasena(String usuario, String psw) throws Exception {
        try {
            Optional<Usuario> entity = repo.findByUsuarioAndContrasena(usuario, psw);
            return entity.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
/*
    @Transactional
    public Usuario findByUsuario(String usuario) throws Exception{
        try{
            Optional<Usuario> entity = repo.findByUsuario(usuario);
            return entity.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
*/

    @Transactional
    public Usuario save(Usuario u) throws Exception {
        try {
            Usuario user = repo.save(u);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
