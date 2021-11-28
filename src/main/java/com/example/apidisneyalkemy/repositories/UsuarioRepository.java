package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario WHERE usuario.usuario_nombre = :user AND usuario.contrasena = :psw", nativeQuery = true)
    Optional<Usuario> findByUsuarioAndContrasena(@Param("user") String usuario, @Param("psw") String contrasena);
/*
    @Query(value = "SELECT * FROM usuario WHERE usuario.usuario_nombre = :user ", nativeQuery = true)
    Optional<Usuario> findByUsuario(@Param("user") String usuario);
*/
}
