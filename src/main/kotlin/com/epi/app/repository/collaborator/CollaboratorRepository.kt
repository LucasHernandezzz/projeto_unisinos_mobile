package com.epi.app.repository.collaborator

import com.epi.app.entity.collaborator.Collaborator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollaboratorRepository : JpaRepository<Collaborator, Long> {

    fun existsByCpf(cpf: String): Boolean
}