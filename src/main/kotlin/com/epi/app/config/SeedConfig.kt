package com.epi.app.config

import com.epi.app.entity.user.User
import com.epi.app.repository.user.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SeedConfig {
    @Bean
    fun seed(repo: UserRepository, encoder: PasswordEncoder) =
        CommandLineRunner {
            if (repo.findByEmail("sa@local").isEmpty) {
                repo.save(User(
                    email = "sa@local", password = encoder.encode("123456"),
                    name = "admin",
                    cpf = "123.456.789-00"
                ))
            }
        }
}