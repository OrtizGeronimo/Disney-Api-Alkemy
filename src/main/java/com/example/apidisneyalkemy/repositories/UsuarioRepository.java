package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public abstract Usuario findByUsuario(String usuario);

}
