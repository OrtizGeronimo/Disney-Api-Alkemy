package com.example.apidisneyalkemy.controllers;

import com.example.apidisneyalkemy.config.User;
import com.example.apidisneyalkemy.entities.Usuario;
import com.example.apidisneyalkemy.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("user") String username, @RequestParam("psw") String psw){
        try{
            Usuario usuario = service.findByUsuarioAndContrasena(username, psw);
            if (usuario == null){
                throw new Exception();
            }
            String token = getJWTToken(username);
            User u = new User();
            u.setUser(username);
            u.setToken(token);
            return ResponseEntity.status(HttpStatus.OK).body(u);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. "+ e.getMessage() +".\"}");
        }



    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
