package com.epi.app.repository.user

import com.epi.app.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun existsByEmail(email: String): Boolean
    fun existsByCpf(cpf: String): Boolean
    fun findByEmail(email: String): Optional<User>
}