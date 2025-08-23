package com.epi.app.service.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.*

@Service
class JwtService(
    @Value("\${security.jwt.secret}") private val secret: String,
    @Value("\${security.jwt.expiration-seconds:3600}") private val expirationSeconds: Long
) {
    private val key by lazy { Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8)) }

    fun generateToken(user: UserDetails): String {
        val now = Date()
        val exp = Date(now.time + expirationSeconds * 1000)
        return Jwts.builder()
            .subject(user.username)
            .issuedAt(now)
            .expiration(exp)
            .signWith(key)
            .compact()
    }

    fun extractUsername(token: String): String? =
        try { Jwts.parser().verifyWith(key).build().parseSignedClaims(token).payload.subject } catch (_: Exception) { null }

    fun isValid(token: String, user: UserDetails): Boolean =
        extractUsername(token) == user.username &&
                try {
                    val claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).payload
                    claims.expiration.after(Date())
                } catch (_: Exception) { false }
}
