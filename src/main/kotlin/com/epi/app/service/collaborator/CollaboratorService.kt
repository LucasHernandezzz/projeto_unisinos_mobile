package com.epi.app.service.collaborator

import com.epi.app.entity.collaborator.Collaborator
import com.epi.app.entity.user.User
import com.epi.app.exceptions.ValidationException
import com.epi.app.repository.collaborator.CollaboratorRepository
import com.epi.app.repository.user.UserRepository
import com.epi.app.service.collaborator.dto.CollaboratorCreateDto
import com.epi.app.service.collaborator.dto.CollaboratorResponseDto
import com.epi.app.service.collaborator.mapper.ColabMapper
import com.epi.app.service.user.dto.UserCreateDto
import com.epi.app.service.user.dto.UserResponseDto
import com.epi.app.service.user.mapper.UserMapper
import com.epi.app.validate.user.UserValidate
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CollaboratorService(
    private val collaboratorRepository: CollaboratorRepository,
    private val colabMapper: ColabMapper
) {
    fun create(dto: CollaboratorCreateDto) {

        if (collaboratorRepository.existsByCpf(dto.cpf)) {
            throw ValidationException("O cpf ${dto.cpf} já está em uso.")
        }

        val colab: Collaborator = Collaborator(
            name = dto.name,
            cpf = dto.cpf,
             signature = dto.signature,
        )
        collaboratorRepository.save(colab)
    }

    fun getCollabById(id: Long): CollaboratorResponseDto? {
        val colab = collaboratorRepository.findById(id).orElseThrow { ValidationException("Usuário não encontrado") }
        return colabMapper.toColabResponse(colab)
    }

    fun getEntityById(id: Long): Collaborator {
        return collaboratorRepository.findById(id)
            .orElseThrow { Exception("Usuário com ID $id não encontrado") }
    }
}