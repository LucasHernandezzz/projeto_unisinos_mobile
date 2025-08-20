package com.epi.app.service.user

import com.epi.app.repository.user.UserRepository
import org.springframework.context.annotation.Primary
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@Primary
class JpaUserDetailsService(private val repo: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val u = repo.findByEmail(username)
            .orElseThrow { UsernameNotFoundException("User not found") }

        return org.springframework.security.core.userdetails.User
            .withUsername(u.email)
            .password(u.password)
            .accountExpired(false).accountLocked(false).credentialsExpired(false).disabled(false)
            .build()
    }
}
