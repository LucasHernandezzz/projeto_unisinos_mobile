package com.epi.app.util

import com.epi.app.service.jwt.JwtService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        val authHeader = req.getHeader("Authorization")
        val token = if (authHeader != null && authHeader.startsWith("Bearer ")) authHeader.substring(7) else null

        if (token != null && SecurityContextHolder.getContext().authentication == null) {
            val username = jwtService.extractUsername(token)
            if (username != null) {
                val userDetails = userDetailsService.loadUserByUsername(username)
                if (jwtService.isValid(token, userDetails)) {
                    val auth = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                    auth.details = WebAuthenticationDetailsSource().buildDetails(req)
                    SecurityContextHolder.getContext().authentication = auth
                }
            }
        }
        chain.doFilter(req, res)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        val path = request.servletPath
        return path.startsWith("/auth/") || path.startsWith("/h2-console")
    }
}
