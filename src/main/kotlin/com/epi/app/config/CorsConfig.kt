package com.epi.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {
    init {
        println("🚀 CorsConfig foi carregado!")
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()

        // Permitir origem específica
        configuration.allowedOriginPatterns = listOf("http://localhost:4200","http://localhost:8100")

        // PERMITIR TODAS as origens durante desenvolvimento
        //configuration.allowedOriginPatterns = listOf("*")

        // Métodos permitidos
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")

        // Headers permitidos
        configuration.allowedHeaders = listOf("*")

        // Permitir credenciais
        configuration.allowCredentials = false

        // Headers expostos (importante para JWT)
        configuration.exposedHeaders = listOf("Authorization")

        // Registrar para todas as rotas
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)

        return source
    }
}