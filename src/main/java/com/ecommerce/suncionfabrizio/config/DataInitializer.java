package com.ecommerce.suncionfabrizio.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.suncionfabrizio.entity.Usuario;
import com.ecommerce.suncionfabrizio.repository.UsuarioRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner crearUsuarioInicial(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("fabrizio").isEmpty()) {
                repo.save(new Usuario(null, "fabrizio", encoder.encode("123456"), "ROLE_ADMIN"));
            }
        };
    }
}