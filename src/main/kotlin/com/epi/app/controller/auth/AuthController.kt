package com.epi.app.controller.auth

import com.epi.app.service.jwt.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.*

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
) {
    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): ResponseEntity<LoginResponse> {
        val auth = UsernamePasswordAuthenticationToken(req.email, req.password)
        authenticationManager.authenticate(auth) // lança se inválido
        val user = userDetailsService.loadUserByUsername(req.email)
        val token = jwtService.generateToken(user)
        return ResponseEntity.ok(LoginResponse(token))
    }
}
